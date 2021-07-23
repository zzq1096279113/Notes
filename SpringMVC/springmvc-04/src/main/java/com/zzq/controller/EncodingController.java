package com.zzq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 编码问题
 * @ClassName EncodingController
 * @Author zzq
 * @Date 2021/7/6 14:27
 */
@Controller
@RequestMapping("/encoding")
public class EncodingController {

    @PostMapping("/t1")
    public String test1(String name, Model model) {
        System.out.println(name);
        model.addAttribute("result", name);
        return "test";
    }

}
