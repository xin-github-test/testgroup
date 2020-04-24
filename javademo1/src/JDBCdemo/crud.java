package JDBCdemo;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class crud {
    @Test
    public void tcrud()
    {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            conn =DBUtils.getConnections();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("select * from student");
            List<student> list =new ArrayList<student>();
            while (rs.next())
            {
                student stu=new student();
                stu.setStuid(rs.getInt(1));
                stu.setStuname(rs.getString(2));
                list.add(stu);
            }
            for (student stu:list)
            {
                System.out.println(stu.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(rs,stmt,conn);
        }
    }
}
