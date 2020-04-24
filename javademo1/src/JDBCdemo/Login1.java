package JDBCdemo;

import java.util.Scanner;

public class Login1 {
    public static void main(String []args)
    {

        Scanner input =new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name =input.nextLine();
        System.out.println("请输入密码：");
        String   password =input.nextLine();
        Dologin1 dl=new Dologin1();
        student stu = dl.findstu(name, password);
        if (stu != null) {
            System.out.println("欢迎回来："+stu.getStuname());
        }
        else
        {
            System.out.println("用户不存在！");
        }

    }
}
