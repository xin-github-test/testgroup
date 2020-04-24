package com.itheima.util;

import com.itheima.entity.Book;

import java.util.HashMap;
import java.util.Map;

public class DButil {
    private  static Map<String,Book> books=new HashMap<String,Book>();
    static
    {
        books.put("1",new Book("1","javaweb",20.00,"黑马"));
        books.put("2",new Book("2","html",59.90,"小红"));
        books.put("3",new Book("3","javascript",35.70,"小明"));
        books.put("4",new Book("4","css",40.00,"小华"));

    }
    public static Map<String,Book> findAllBooks()//得到所有的图书的列表
    {
        return books;
    }
    public static Book findById(String id) //通过id将指定的书找到
    {
        return books.get(id);
    }
}
