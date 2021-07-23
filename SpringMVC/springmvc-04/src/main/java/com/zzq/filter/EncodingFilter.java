package com.zzq.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 转型为与协议相关对象
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        // 处理response的字符编码
        httpServletResponse.setContentType("text/html;charset=UTF-8");
        // 对request包装增强
        HttpServletRequest myRequest = new MyRequest(httpServletRequest);
        chain.doFilter(myRequest, httpServletResponse);
    }


    @Override
    public void destroy() {

    }
}

class MyRequest extends HttpServletRequestWrapper {

    private HttpServletRequest request;
    private boolean hasEncode;  // 是否编码的标记

    public MyRequest(HttpServletRequest request) {
        super(request);// super必须写
        this.request = request;
    }

    @Override
    public Map getParameterMap() {
        String method = request.getMethod();    // 先获得请求方式
        if (method.equalsIgnoreCase("post")) {  // post请求
            try {
                request.setCharacterEncoding("utf-8");
                return request.getParameterMap();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else if (method.equalsIgnoreCase("get")) {    // get请求
            Map<String, String[]> parameterMap = request.getParameterMap();
            if (!hasEncode) {   // 确保get手动编码逻辑只运行一次
                for (String parameterName : parameterMap.keySet()) {
                    String[] values = parameterMap.get(parameterName);
                    if (values != null) {
                        for (int i = 0; i < values.length; i++) {
                            try {
                                values[i] = new String(values[i].getBytes("ISO-8859-1"), "utf-8");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                hasEncode = true;
            }
            return parameterMap;
        }
        return super.getParameterMap();
    }

    @Override
    public String getParameter(String name) {
        Map<String, String[]> parameterMap = getParameterMap();
        String[] values = parameterMap.get(name);
        if (values == null) {
            return null;
        }
        return values[0]; // 取回参数的第一个值
    }


    @Override
    public String[] getParameterValues(String name) {   // 取所有值
        Map<String, String[]> parameterMap = getParameterMap();
        String[] values = parameterMap.get(name);
        return values;
    }
}
