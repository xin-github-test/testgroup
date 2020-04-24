package C3P0;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.SQLException;

public class testCRUD {
    @Test
    public void testInsert() throws SQLException {
        //获得queryRunner对象
        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
       qr.update("insert into user(username,password,email,birthday)values(?,?,?,?)","cat","456","cat@qq.com","2019-3-2");

    }
    @Test
    public void testUpdate() throws SQLException {
        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
        qr.update("update user set username=? where id=?","catt","24");

    }

@Test
public void testDelete() throws SQLException {
    QueryRunner qr=new QueryRunner(c3p0.getDataSource());
    qr.update("delete from users where id=?",23);
}
    @Test
    public void testBatch() throws SQLException {//批处理只能执行相同的sql语句
        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
        Object[][] params=new Object[10][];//高维代表执行多少次sql语句，后面为?号的值
        for (int i = 0; i < params.length; i++) {
            params[i]=new Object[]{"cat","456"+i,"cat@qq.com","2019-3-2"};
        }
        qr.batch("insert into user(username,password,email,birthday)values(?,?,?,?)",params);
    }
}
