package com.itheima.Service;

import com.itheima.Dao.BookDaoImpl;
import com.itheima.domain.Book;
import com.itheima.domain.PageBean;

import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl {
    //创建一个Dao对象
    BookDaoImpl bookDao=new BookDaoImpl();
    //调用查询图书的方法
    public List<Book> findAllBooks() {
        try {
            return  bookDao.findAllBooks();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //调用添加图书的方法
    public void addBook(Book book)
    {
        try {
            bookDao.addBook(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Book findBookById(String id) {
        try {
            return bookDao.findBookById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateBook(Book book) {
        try {
            bookDao.updateBook(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(String id) {
        try {
            bookDao.delBook(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleAllBooks(String[] ids) {
        try {
            bookDao.deleAllBooks(ids);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Book> searchBooks(String id, String category, String name, String minprice, String maxprice) {
        try {
            return bookDao.searchBooks(id,category,name,minprice,maxprice);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public PageBean findBooksPage(int currentPage, int pageSize) {
        try {
            int count=bookDao.count();//总记录数
            int totalPage=(int)Math.ceil(count*1.0/pageSize);//总页数
            List<Book> books=bookDao.findBooks(currentPage,pageSize);

           return new PageBean(currentPage,pageSize,count,totalPage,books);//将数据都封装在pageBean中，然后将其返回

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Object> searchBookByName(String name) {
        try {
            return bookDao.searchBookByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
