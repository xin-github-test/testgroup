package zidongdenglu.Dao;

import C3P0.c3p0;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import zidongdenglu.domain.User;

import java.sql.SQLException;

public class UserDao {
    public User findUser(String username, String password) throws SQLException {
        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
       return qr.query("select * from user where username=? and password=?",new BeanHandler<User>(User.class),username,password);
    }
}
