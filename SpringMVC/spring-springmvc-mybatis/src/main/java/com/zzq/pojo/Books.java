package com.zzq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description Book类
 * @ClassName Books
 * @Author zzq
 * @Date 2021/7/6 20:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {

    private int bookId;
    private String bookName;
    private int bookCounts;
    private String bookDetail;

}
