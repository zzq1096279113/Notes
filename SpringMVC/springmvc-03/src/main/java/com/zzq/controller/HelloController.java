package com.zzq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 使用注解开发
 * @ClassName HelloController
 * @Author zzq
 * @Date 2021/7/5 17:49
 */
@Controller
@RequestMapping("/HelloController")
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello Spring-MVC!");
        return "hello";
    }

}
