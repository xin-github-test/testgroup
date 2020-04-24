package com.itheima.Dao;

import com.itheima.domain.Book;
import com.itheima.utils.c3p0;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl {
    //查找所有的图书
    public List<Book> findAllBooks() throws SQLException {
        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
        return qr.query("select * from book",new BeanListHandler<Book>(Book.class));

    }
    //添加图书
    public void addBook(Book book)throws SQLException
    {
        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
        qr.update("INSERT INTO book VALUES(?,?,?,?,?,?,?);",book.getId(),book.getName(),book.getPrice(),book.getPnum(),book.getCategory(),book.getDescription(),book.getImg_url());
    }

    /**
     *
     * @param id
     */
    public Book findBookById(String id) throws SQLException{
        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
        return qr.query("select * from book where id=?",new BeanHandler<Book>(Book.class),id);

    }

    public void updateBook(Book book) throws SQLException {
        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
        qr.update("update book set name=?,price=?,pnum=?,category=?,description=? where  id=?",book.getName(),book.getPrice(),book.getPnum(),book.getCategory(),book.getDescription(),book.getId());
    }

    public void delBook(String id) throws SQLException {
        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
        qr.update("delete from book where id=?",id);
    }

    public void deleAllBooks(String[] ids) throws SQLException {
        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
        Object[][] par=new Object[ids.length][];
        for (int i = 0; i < par.length; i++) {
            par[i]=new Object[]{ids[i]};
        }


        qr.batch("delete from book where id=?",par);
    }

    public List<Book> searchBooks(String id, String category, String name, String minprice, String maxprice) throws SQLException {
        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
        String sql="select * from book where 1=1";
        List list=new ArrayList();
       if(!"".equals(id))
       {
           sql+=" and id like ?";//注意：不能在?旁边加俩个%,不然到时候效果回变成 %'1001'%
           list.add("%"+id+"%"); //在这里加的效果是 '%1001%'(正确的）
       }if(!"".equals(category))
       {
           sql+=" and category=?";
           list.add(category);
       }if(!"".equals(name))
       {
           sql+=" and name like ?";
           list.add("%"+name+"%");
       }if(!"".equals(minprice))
       {
           sql+=" and price >?";
           list.add(minprice);
       }if(!"".equals(maxprice))
       {
           sql+=" and price <?";
           list.add(maxprice);
       }

        return qr.query(sql,new BeanListHandler<Book>(Book.class),list.toArray());

    }

    public int count() throws SQLException {
        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
       long l = (Long)qr.query("select count(*) from book", new ScalarHandler(1));
       return (int)l;
    }

    public List<Book> findBooks(int currentPage, int pageSize) throws SQLException {
        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
        return qr.query("select * from book limit ?,?",new BeanListHandler<Book>(Book.class),(currentPage-1)*pageSize,pageSize);
    }

    public List<Object> searchBookByName(String name) throws SQLException {
        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
       return qr.query("select name from book where name like ?",new ColumnListHandler(),"%"+name+"%");
    }
}
