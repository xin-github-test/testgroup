package C3P0;

import com.itheima.Domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class testselect{
    @Test
    public void testselect() throws SQLException {
        //创建一个QueryRunner对象
        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
        List<User> list=qr.query("select * from user", new ResultSetHandler<List<User>>() {//实际可以不用new这个方法，其里面已经有已经写好的方法
            //当query执行完select语句后，会将结果集作为参数传给下面的方法
            @Override
            public List<User> handle(ResultSet resultSet) throws SQLException {
                List<User> list=new ArrayList<>();
                while(resultSet.next())
                {
                    User u=new User();
                    u.setId(resultSet.getInt(1));
                    u.setUsername(resultSet.getString(2));
                    u.setPassword(resultSet.getString(3));
                    u.setEmail(resultSet.getString(4));
                    u.setBirthday(resultSet.getDate(5));
                   list.add(u);
                }
                return list;
            }
        });
        for (User user:list
             ) {
            System.out.println(user);

        }
    }
    @Test
    public void testselect2() throws SQLException
    {
        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
        List<User> list=qr.query("select * from user where id=?",new BeanListHandler<User>(User.class),23);//后面可以跟多个参数，个数取决于前面的?号
        for (User user
                :list
             ) {
            System.out.println(user.getUsername());
        }
    }

}
