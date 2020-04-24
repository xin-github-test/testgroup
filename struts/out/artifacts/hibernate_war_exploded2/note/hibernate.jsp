<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/4/20
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hibernate笔记</title>
</head>
<body>
  一、介绍：
  1.struts2是web层的，hibernate是dao层的，而spring 是管理web ,service,dao三个层面的
 其中：struts2:架构最简单，思想并不简单
       hibernate:架构最复杂，但使用和思想比较简单
 2.hibernate入门
  1）ORM框架（Object Relational Mapping)：对象关系映射：是一种程序技术，用于实现面向对象编程语言里不同类型的数据之间的转换。从效果上说，它其实是创建了一个可在编程语言里使用的虚拟对象数据库
  2）Hibernate:是一个数据持久化层的ORM框架
     Object :对象，java对象，此处特指javaBean
     Relational:关系，二维表，数据库中的表
     Mapping:映射元数据：对象中属性，与表的字段，存在对应关系
 学习Hibernate之后：会使对数据库的操作，变成一个面向对象的操作，
 我们在Hibernate 中需要使用面向对象的思想操作数据库，我们需要告诉Hibernate我们的对象和数据库中表的关系
 Orm数据元 =》配置文件
 3.优点：1）对jdbc访问数据库的代码做了封装，大大简化了数据访问层繁琐的重复性代码
         2）是一个基于jdbc的主流持久化框架，是一个优秀的orm实现，它很大程度上简化了dao层编码工作
         3）使用java的反射机制
         4）性能非常好，因为他是一个轻量级框架，映射的灵活性很出色，它支持很多关系型数据库，从一对多到多对多的各种复杂关系
</body>
</html>
