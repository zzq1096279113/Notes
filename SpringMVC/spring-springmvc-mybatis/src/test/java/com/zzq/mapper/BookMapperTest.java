package com.zzq.mapper;

import com.zzq.pojo.Books;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description BookMapper测试类
 * @ClassName BookMapperTest
 * @Author zzq
 * @Date 2021/7/6 20:23
 */
public class BookMapperTest {

    @Test
    public void addBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        BookMapper mapper = context.getBean("bookMapper", BookMapper.class);
        mapper.addBook(new Books(0, "剑指offer", 6, "面试"));
    }

    @Test
    public void deleteBookById() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        BookMapper mapper = context.getBean("bookMapper", BookMapper.class);
        mapper.deleteBookById(5);
    }

    @Test
    public void updateBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        BookMapper mapper = context.getBean("bookMapper", BookMapper.class);
        mapper.updateBook(new Books(4, null, 6, "面试准备"));
    }

    @Test
    public void queryBookById() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        BookMapper mapper = context.getBean("bookMapper", BookMapper.class);
        Books book = mapper.queryBookById(2);
        System.out.println(book);
    }

    @Test
    public void queryAllBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        BookMapper mapper = context.getBean("bookMapper", BookMapper.class);
        List<Books> books = mapper.queryAllBook();
        for (Books book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void queryBookByName() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        BookMapper mapper = context.getBean("bookMapper", BookMapper.class);
        List<Books> books = mapper.queryBookByName("L");
        for (Books book : books) {
            System.out.println(book);
        }
    }
}