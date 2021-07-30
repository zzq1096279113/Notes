package com.zzq.controller;

import com.zzq.pojo.Books;
import com.zzq.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Description Book的Controller层
 * @ClassName BookController
 * @Author zzq
 * @Date 2021/7/7 10:43
 */
@Controller
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/allBook")
    public String showAllBook(Model model) {
        List<Books> books = bookService.queryAllBook();
        model.addAttribute("list", books);
        return "allBook";
    }

    @GetMapping("/addBook")
    public String toAddBook(Model model) {
        return "addBook";
    }

    @PostMapping("/addBook")
    public String addBook(Books book) {
        bookService.addBook(book);
        return "redirect:/book/allBook";
    }

    @GetMapping("/updateBook")
    public String toUpdateBook(int id, Model model) {
        Books book = bookService.queryBookById(id);
        model.addAttribute("book", book);
        return "updateBook";
    }

    @PostMapping("/updateBook")
    public String updateBook(Books book) {
        bookService.updateBook(book);
        return "redirect:/book/allBook";
    }

    @GetMapping("/deleteBook")
    public String deleteBook(int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    @PostMapping("/queryBookByName")
    public String queryBookByName(String bookName, Model model){
        if("".equals(bookName)){
            return "redirect:/book/allBook";
        }
        else {
            List<Books> books = bookService.queryBookByName(bookName);
            model.addAttribute("list", books);
            return "allBook";
        }
    }
}
