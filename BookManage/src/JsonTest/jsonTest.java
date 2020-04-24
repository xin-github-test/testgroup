package JsonTest;

import com.itheima.domain.Book;
import com.itheima.utils.c3p0;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class jsonTest {
    @Test //使用JSONObject封装对象类型数据（数组就用JSONArray封装）
    public void test1()
    {
        Book book=new Book();
        book.setId("1001");
        book.setName("xyj");
        //book.setPnum(30);
        book.setPrice(20);
        //book.setCategory("文学");
        //book.setDescription("好书");

        //利用json进行封装
        String s = JSONObject.fromObject(book).toString();
        System.out.println(s);



    }
    @Test
    public void test2()
    {

        List<Book> list =new ArrayList<Book>();
        Book book1=new Book();
        book1.setId("1001");
        book1.setName("xyj");
        //book.setPnum(30);
        book1.setPrice(20);

        Book book2=new Book();
        book2.setId("1001");
        book2.setName("xyj");
        //book.setPnum(30);
        book2.setPrice(20);

        list.add(book1);
        list.add(book2);
        //利用json封装对象
        String s = JSONArray.fromObject(list).toString();
        System.out.println(s);


    }
    @Test
    public void test3() throws SQLException {
        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
        List<Book> list = qr.query("select * from book", new BeanListHandler<Book>(Book.class));
        JsonConfig jc=new JsonConfig();
        //去除不需要的元素，数组中的元素就是排除的元素,但是需要向fromObject传参
        jc.setExcludes(new String []{"pnum","description","category","id"});
        String s = JSONArray.fromObject(list,jc).toString();
        System.out.println(s);
    }
}
