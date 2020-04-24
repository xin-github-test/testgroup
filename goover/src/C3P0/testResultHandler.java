package C3P0;

import com.itheima.Domain.User;
import org.apache.commons.dbutils.QueryRunner;
//import org.apache.commons.dbutils.handlers.AbstractListHandler;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//import static org.graalvm.compiler.options.OptionType.User;

public class testResultHandler {
    @Test//ArrayHandler:适合取一条数据，将该条记录的每个值封装到一个Object[]中
    public void test1() throws SQLException {
        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
  Object[] obj=qr.query("select * from user where id=?",new ArrayHandler(),22);
        for (Object o:obj
             ) {
            System.out.println(o);
        }
    }
    @Test//取多行数据，把每一行数据放在一个数组中，然后将整个数组放入一个集合中
    public void test2()throws SQLException{

        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
        List<Object[]> query = qr.query("select * from user", new ArrayListHandler());
        for (Object[] o :   //第一层遍历集合，第二层遍历集合中的object数组
                query) {
            for (Object u:o
                 ) {
                System.out.println(u);
            }

        }
    }
    @Test//取某一列的数据，封装到list中
    public void test3 ()throws SQLException
    {
        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
        List<Object> query = qr.query("select * from user", new ColumnListHandler(1));//其中参数的列数取决于select语句中查询后显示的列
        for (Object o :
                query) {
            System.out.println(o);
        }
    }
    @Test//取多条记录，每一条记录封装到一个Map中，再把这个Map封装到另一个Map中，key为指定的字段值
     public void test4()throws SQLException
    {
       QueryRunner qr=new QueryRunner(c3p0.getDataSource());
        Map<Object, Map<String, Object>> query = qr.query("select * from user", new KeyedHandler(1));//外面的Map是object 类型是因为那是用户自己指定的，里面的那个是列名，所以是String,其中参数1指的是将表中第几列作为大Map的key
        for (Map.Entry<Object, Map<String, Object>> m :query.entrySet()
                ) {
            System.out.println(m.getKey());//大Map的key就是上面指定的列数（就是id的那一列）
            for (Map.Entry<String, Object> mm :m.getValue().entrySet()
                    ) {
                System.out.println(mm.getKey()+"\t"+mm.getValue());
            }

        }
    }
    @Test//适合取一条数据，把当前的列名和列值放入到一个Map集合中去（上面的简化版）
    public void test5()throws SQLException
    {
      QueryRunner qr=new QueryRunner(c3p0.getDataSource());
        Map<String, Object> query = qr.query("select * from user where id=?", new MapHandler(), 22);
        for (Map.Entry<String, Object> mm:
        query.entrySet()){
        System.out.println(mm.getKey()+"\t"+mm.getValue());
    }
    }
    @Test //适合取多条数据，把每条记录封装到一个Map中，再把Map封装到List中
    public void test6()throws SQLException
    {
        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
        List<Map<String,Object>> list=qr.query("select * from user",new MapListHandler());
        for (Map<String,Object> m:list
        ){
            for (Map.Entry<String, Object> mm:m.entrySet()
            ){
                System.out.println(mm.getKey()+"\t"+mm.getValue());
            }
    }
    }
    @Test//适合取单行单列数据(一个单元格)
    public void test7()throws SQLException
    {
QueryRunner qr=new QueryRunner(c3p0.getDataSource());
Object o=qr.query("select count(*) from user",new ScalarHandler(1));//去一个单元格，其中数字参数代表取第几列,该数字是参照select执行后得出的表单
        System.out.println(o);
    }
    @Test //适合取单行单列数据
    public void test8() throws SQLException
    {
        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
        User user=qr.query("select * from user",new BeanHandler<User>(User.class));
        System.out.println(user.toString());

    }
    @Test
    public void test9()throws SQLException
    {
  QueryRunner qr=new QueryRunner(c3p0.getDataSource());
  List<User>list=qr.query("select * from user where id=?",new BeanListHandler<User>(User.class),22);
        System.out.println(list.size());
  for (User user :list
                ) {
            System.out.println(user);

        }
    }

}
