package com.zzq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @Description RestFul风格
 * @ClassName RestFulController
 * @Author zzq
 * @Date 2021/7/6 9:23
 */
@Controller
public class RestFulController {

//    // http://localhost:8080/springmvc_03/add?a=3&b=5
//    @RequestMapping("/add")
//    public String test1(Model model, int a, int b) {
//        int result = a + b;
//        model.addAttribute("result", result);
//        return "test";
//    }

    @RequestMapping("/add/{a}/{b}")
    public String test2(Model model, @PathVariable int a, @PathVariable int b) {
        int result = a + b;
        model.addAttribute("result", result);
        return "test";
    }

    @RequestMapping(value = "/add/{a}/{b}", method = {RequestMethod.GET})
    public String test3(Model model, @PathVariable int a, @PathVariable int b) {
        String result = a + b + "Get";
        model.addAttribute("result", result);
        return "test";
    }

    @PostMapping("/add/{a}/{b}")
    public String test4(Model model, @PathVariable int a, @PathVariable int b) {
        String result = a + b + "Post";
        model.addAttribute("result", result);
        return "test";
    }

}
