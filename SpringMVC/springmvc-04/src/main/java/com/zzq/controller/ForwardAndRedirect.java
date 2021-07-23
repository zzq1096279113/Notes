package com.zzq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 跳转
 * @ClassName ForwardAndRedirect
 * @Author zzq
 * @Date 2021/7/6 10:28
 */
@Controller
@RequestMapping("/ForwardAndRedirect")
public class ForwardAndRedirect {

    @RequestMapping("/t1")
    public void test1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("result", "t1");
        request.getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(request, response);
    }

    @RequestMapping("/t2")
    public void test2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("result", "t2");
        response.sendRedirect("index.jsp");
    }

    @RequestMapping("/t3")
    public String test3(Model model) {
        model.addAttribute("result", "t3");
        return "/WEB-INF/jsp/test.jsp";
    }

    @RequestMapping("/t4")
    public String test4(Model model) {
        model.addAttribute("result", "t4");
        return "redirect:/index.jsp";
    }

    @RequestMapping("/t5")
    public String test5(Model model) {
        model.addAttribute("result", "t5");
        return "test";
    }

    @RequestMapping("/t6")
    public String test6(Model model) {
        model.addAttribute("result", "t6");
        return "redirect:/index.jsp";
    }
}
