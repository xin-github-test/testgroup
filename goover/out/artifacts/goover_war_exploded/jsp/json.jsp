<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/2/3
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
     <script>
         /*
            java中创建类：
             public class person{
               private String name;
               private int age;

               public void show()
               {
               }

             }

             js中创建类：
             function Person()
             {
                var name;  //声明一个变量
                var age;
             }
             var p=new Person();  //创建类对象
          */
        /* function Person()
         {
             var name="张三";  //声明一个变量(只是一个局部变量，脱离该范围就无效）
             this.age="50岁";   //要声明一个成员变量，就不能是var了，是：this.age

             this.show=function () {  //声明一个成员方法
                 document.write(name);

             }
         }
         var p=new Person();  //创建类对象

         //document.write(p.name+","+p.age);//此处取不到初始化的值，因为其只是局部变量
         document.write(p.age);//因为age声明的是成员变量，所以此处可以取到值
         p.show();*/
        var ss=["1001","1002"]; //这样写为数组；
         var pp={name:"tom",age:18,show:function () {alert(this.name);

             }}    //这样写是一个json对象
         document.write(pp.name+","+pp.age);
         pp.show();
         //json的另一种用法
          var ppp=[{name:"tom",age:18},{name:"jerry",age:19}]//一个数组，里面放了俩个json对象
          //从数组中取出json对象
          document.write(ppp[1].name);
     </script>
</body>
</html>
