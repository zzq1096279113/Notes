package com.zzq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @ClassName TestController
 * @Author zzq
 * @Date 2021/7/8 15:17
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test() {
        System.out.println("Controller");
        return "测试Controller";
    }

}
