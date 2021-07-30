package com.zzq.service;

import com.zzq.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description Book的Service层
 * @ClassName BookService
 * @Author zzq
 * @Date 2021/7/6 20:26
 */
public interface BookService {
    public void addBook(Books book);

    public void deleteBookById(int id);

    public void updateBook(Books book);

    public Books queryBookById(int id);

    public List<Books> queryAllBook();

    public List<Books> queryBookByName(String bookName);
}
