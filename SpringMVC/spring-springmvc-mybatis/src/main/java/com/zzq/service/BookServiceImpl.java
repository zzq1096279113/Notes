package com.zzq.service;

import com.zzq.mapper.BookMapper;
import com.zzq.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description Service实现类
 * @ClassName BookServiceImpl
 * @Author zzq
 * @Date 2021/7/6 20:27
 */
@Service
public class BookServiceImpl implements BookService {

    private BookMapper bookMapper;

    @Autowired
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public void addBook(Books book) {
        System.out.println("增加一本书");
        bookMapper.addBook(book);
    }

    @Override
    public void deleteBookById(int id) {
        System.out.println("删除一本书");
        bookMapper.deleteBookById(id);
    }

    @Override
    public void updateBook(Books book) {
        System.out.println("修改一本书");
        bookMapper.updateBook(book);
    }

    @Override
    public Books queryBookById(int id) {
        System.out.println("按Id查询书");
        return bookMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBook() {
        System.out.println("查询所有书");
        return bookMapper.queryAllBook();
    }

    @Override
    public List<Books> queryBookByName(String bookName) {
        System.out.println("按名字查询书");
        return bookMapper.queryBookByName(bookName);
    }
}
