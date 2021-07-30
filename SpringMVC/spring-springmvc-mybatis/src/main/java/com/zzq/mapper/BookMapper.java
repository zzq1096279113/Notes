package com.zzq.mapper;

import com.zzq.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description 操作数据库Book
 * @ClassName BookMapper
 * @Author zzq
 * @Date 2021/7/6 20:11
 */
public interface BookMapper {

    /**
     * @Description 添加书籍
     * @Param [book]
     * @Return void
     * @Author zzq
     * @Date 2021/7/6 21:29
     */
    public void addBook(Books book);

    /**
     * @Description 按ID删除书籍
     * @Param [id]
     * @Return void
     * @Author zzq
     * @Date 2021/7/6 21:29
     */
    public void deleteBookById(@Param("id") int id);

    /**
     * @Description 修改书籍信息
     * @Param [book]
     * @Return void
     * @Author zzq
     * @Date 2021/7/6 21:30
     */
    public void updateBook(Books book);

    /**
     * @Description 按照ID查询书籍
     * @Param [id]
     * @Return com.zzq.pojo.Books
     * @Author zzq
     * @Date 2021/7/6 21:30
     */
    public Books queryBookById(@Param("id") int id);

    /**
     * @Description 查询所有书籍
     * @Param []
     * @Return java.util.List<com.zzq.pojo.Books>
     * @Author zzq
     * @Date 2021/7/6 21:30
     */
    public List<Books> queryAllBook();

    /**
     * @Description 通过书名查询
     * @Param [bookName]
     * @Return java.util.List<com.zzq.pojo.Books>
     * @Author zzq
     * @Date 2021/7/7 17:17
     */
    public List<Books> queryBookByName(@Param("bookName") String bookName);

}
