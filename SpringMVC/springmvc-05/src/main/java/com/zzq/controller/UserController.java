package com.zzq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Description 用户登录控制器
 * @ClassName UserController
 * @Author zzq
 * @Date 2021/7/8 15:42
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * @Description 跳转到登录页面
     * @Param []
     * @Return java.lang.String
     * @Author zzq
     * @Date 2021/7/19 18:12
     */
    @GetMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * @Description 对表单进行验证并跳转
     * @Param [username, password, session]
     * @Return java.lang.String
     * @Author zzq
     * @Date 2021/7/19 18:12
     */
    @PostMapping("/login")
    public String login(String username, String password, HttpSession session) {
        if ("zzq".equals(username) && "123456".equals(password)) {
            session.setAttribute("user", username);
            return "success";
        } else {
            return "login";
        }
    }

    /**
     * @Description 退出登录
     * @Param [session]
     * @Return java.lang.String
     * @Author zzq
     * @Date 2021/7/19 18:13
     */
    @GetMapping("/logout")
    public String toLogout(HttpSession session){
        session.invalidate();
        return "login";
    }

    /**
     * @Description 跳转到登录成功页面
     * @Param []
     * @Return java.lang.String
     * @Author zzq
     * @Date 2021/7/19 18:13
     */
    @GetMapping("/success")
    public String toSuccess(){
        return "success";
    }

}
