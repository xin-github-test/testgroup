package DBCP;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class testjdbc {
    Connection conn=null;
    PreparedStatement ps=null;

    @Test
    public void test1()
    {
        try {
          conn=DBCPUtil.getConnection();
            ps=conn.prepareStatement(".");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBCPUtil.release(conn,ps,null);
        }

    }
}
