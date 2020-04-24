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
 4.PO(persistent Object):持久化对象
   BO(Business object):业务数据对象 --service层
   VO（Value Object):值对象 --wen层
 二、详解configuration对象：（加载用户配置文件）
    2.1调用configure()方法，加载src下名为hibernate.cfg.xml的文件
    2.2如果配置文件不符合默认加载规则，我们可以调用
        new Configuration.configure(file):通过file加载
        new Configuration.configure(path)：通过路径加载
    2.3可以通过Configuration对象加载映像文件（不推荐），推荐使用hibernate.cfg.xml文件中的mapping 属性来引入配置文件

        规范：1）orm映射文件名称与实体的简单类名一致
              2）需要与实体类在同一包下
        conf.addClass(User.class)(不推荐使用的加载映像文件）
 三、Hibernate 中持久化类
     1.编写规则：
        1）.提供一个无参数，public 访问控制的构造器（方便通过反射来创建对象）
        2）.提供一个标识属性，映射数据表中的主键字段
        3）.所有属性提供public 访问控制符的set get方法
        4）.标识属性应尽量使用基本数据类型的包装类型
        5）.不要用final修饰实体（将无法生成代理对象进行优化）
     2.持久化对象的唯一标识 OID
        1）.java按地址区分同一个类的不同对象
        2）.关系数据库用主键区分同一条记录
        3）.Hibernate使用OID来建立内存中的对象和数据库中记录的对应关系
          结论：对象的OID和数据库的表的主键对应，为保证OID的唯一性，应该让Hibernate来为OID赋值
     3.区分自然主键和代理主键
        主键需要具备：不为空/不能重复/不能改变
           自然主键：在业务中，某个属性符合主键的三个要求，那么该属性可以作为主键列
           代理主键：在业务中，不符合以上三个条件的属性，那么就增加一个没有意义的列作为主键
     4.基本数据与包装数据
        1）：基本数据类型和包装类型对应hibernate的映射类型相同
        2）：基本类型无法表达null,数字类型的默认值为0
        3）：包装类的默认值是null,当对于默认值业务意义的时候需要使用包装类

四、复习：
  1.Hibernate框架：
   功能：Dao层（持久层）框架，封装了JDBC
   思想：整合了ORM的思想，以面向对象的思想操作数据库
  2.Hibernate搭建步骤：
     1》导包
     2》建表
     3》创建实体（model)
     4》填写Hibernate.cfg.xml配置文件
     5》填写实体ORM映射文件（元数据）
     6》写代码
  3.Hibernate操作流程
     1）加载配置文件
     2）根据配置创建sessionFactory
     3) 根据工厂获得session
     4) 开启事务
     5）操作数据库
     6）关闭事务
     7）释放资源
  4.API详解
  5.配置文件详解：
    ibernate.cfg.xml
       方言：每个数据库的方言各不相同，mysql应该配置最短的那个


    orm映射文件

Hibernate的进阶：
一、Hibernate中的对象状态及一级缓存
    对象状态：
      瞬时态|临时态：1.没有与Hibernate产生关联。 2.与数据库中的记录没有产生关联（有关联就是指与数据库中的id有对应）
      持久态：1.与Hibernate有关联。 2.对象有ID
      游离态|托管态：1.没有与Hibernate产生关联(此处与瞬时态不同，此时的对象是由持久态转化而来的，就是可能曾经与Hibernate有关联）。2.对象有ID
    三种状态有什么用？
      1.持久状态：我们使用Hibernate主要时为了持久化我们的数据
      对于对象的状态，我们期望我们需要同步到数据库中的数据，都被转化成持久化
        持久化状态的特点：Hibernate会自动的将对象的持久化状态的变化同步到数据库中
    一级缓存：

二、多表关系在Hibernate中的体现 |操作|配置

</body>
</html>
