package JDBCdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dologin1 {
    public student findstu(String name,String  pwd)
    {
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
         student stu=null;
        try {
            conn=DBUtils.getConnections();
            String sql="SELECT * FROM student WHERE stuid=? AND stuname=?";
            stmt=conn.prepareStatement(sql);//使用statement的子类方法prepareStatement可以预编译sql语句防止注入问题
           stmt.setString(1,pwd);
             stmt.setString(2,name);


            rs=stmt.executeQuery();//这样写会有sql的注入问题  可以绕过判定条件
            if(rs.next())  //如果有值的话就进入下面的语句将该条记录返回
            {
                stu=new student();
                stu.setStuid(rs.getInt(1));
                stu.setStuname(rs.getString(2));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(rs,stmt,conn);
        }


        return stu;
    }

}
