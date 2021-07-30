package com.zzq.service;

import com.zzq.pojo.Books;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Description BookService测试类
 * @ClassName BookServiceTest
 * @Author zzq
 * @Date 2021/7/6 21:41
 */
public class BookServiceTest {

    @Test
    public void addBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("bookServiceImpl", BookService.class);
        bookService.addBook(new Books(0, "剑指offer", 6, "面试"));
    }

    @Test
    public void deleteBookById() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("bookServiceImpl", BookService.class);
        bookService.deleteBookById(6);
    }

    @Test
    public void updateBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("bookServiceImpl", BookService.class);
        bookService.updateBook(new Books(4, null, 7, "面试准备"));
    }

    @Test
    public void queryBookById() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("bookServiceImpl", BookService.class);
        Books book = bookService.queryBookById(3);
        System.out.println(book);
    }

    @Test
    public void queryAllBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("bookServiceImpl", BookService.class);
        List<Books> books = bookService.queryAllBook();
        for (Books book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void queryBookByName() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("bookServiceImpl", BookService.class);
        List<Books> books = bookService.queryBookByName("L");
        for (Books book : books) {
            System.out.println(book);
        }
    }
}