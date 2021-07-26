package com.zzq.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description 登录拦截器
 * @ClassName LoginInterceptor
 * @Author zzq
 * @Date 2021/7/8 15:59
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        // 如果是前往登陆页面或已经登录则放行
        if (request.getRequestURI().contains("ogin") || session.getAttribute("user") != null) {
            System.out.println("已经登录");
            return true;
        }else { //没有登录则回到首页
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            System.out.println("没有登录");
            return false;
        }
    }
}
