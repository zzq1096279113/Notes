package com.zzq.controller;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @ClassName BookControllerTest
 * @Author zzq
 * @Date 2021/7/7 10:55
 */
public class BookControllerTest {

    @Test
    public void showAllBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookController bookController = context.getBean("bookController", BookController.class);
//        String s = bookController.showAllBook(ModelAndView );    // 测试时需要修改 bookController 中传入的参数
//        System.out.println(s);
    }
}