package com.itheima.test2;

import com.itheima.test.HivernateUtils;
import com.itheima.test.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
//对象的三种状态
public class Demo1 {

    //演示三种状态
    @Test
    public void fun1()
    {
        Session session = HivernateUtils.openSession();
        session.beginTransaction();

        User u= new User(); //瞬时状态
        u.setName("tom1");  //瞬时状态
        u.setPassword("www");//瞬时状态

        session.save(u);  //持久状态
                             //问题：调用完save方法后，数据库中有没有对应的记录？
                                //答案：没有对应记录，但是最终会被同步数据库中，仍然是持久状态


        session.getTransaction().commit();//持久状态
        session.clear();//游离状态


    }
    //三种状态的转换
    /**
     * 瞬时=》持久
     * 瞬时=》游离
     * 持久=》瞬时
     * 持久=》游离
     * 游离=》瞬时
     * 游离=》持久
     */
    @Test
    //瞬时到持久
    public void fun2()
    {
        Session session = HivernateUtils.openSession();
        session.beginTransaction();

        User u= new User(); //瞬时状态
        u.setName("tom1");  //瞬时状态
        u.setPassword("www");//瞬时状态

        session.save(u);  //持久状态 调用该方法，就将瞬时转化为持久，save方法会使用主键生成策略，为User 指定id
                          //save方法是为了获取主键id的，如果没有获取到就会报错



        session.getTransaction().commit();//持久状态,事务提交时，会把持久状态同步到数据库中
        session.clear();//游离状态


    }
    //瞬时=》游离
    //瞬时：没有关联，没有id
    //游离：没有关联，有id（与数据库中对应的id)
    @Test
    public void fun3()
    {
        Session session = HivernateUtils.openSession();
        session.beginTransaction();

        User u= new User();//瞬时状态
        u.setId(3);  //游离,对象有与数据库中对应的id，却没有与session关联

        session.getTransaction().commit();
        session.close();
    }

    //持久=》瞬时
    //持久：有关联有id
    //瞬时：无关联，无id
    @Test
    public void fun4()
    {
        Session session = HivernateUtils.openSession();
        session.beginTransaction();

       //通过get获得持久对象
        User u = (User) session.get(User.class, 3);//持久化状态

        //还有一种方法
        /*session.evict(u);//将session与User的关联解除（在没有关闭session的前提下）
        u.setId(0);//瞬时状态*/

        session.getTransaction().commit();
        session.close();//游离状态

        u.setId(0);//瞬时状态
    }

    //持久=>游离
    //只需要将session的关联取消
    @Test
    public void fun5()
    {
        Session session = HivernateUtils.openSession();
        session.beginTransaction();

       //通过get获得持久对象
        User u = (User) session.get(User.class, 3);//持久化状态


        session.evict(u);//此时变为游离


        session.getTransaction().commit();
        session.close();//游离状态


    }

    //游离=》瞬时
    //移除id就行
    @Test
    public void fun6()
    {
        Session session = HivernateUtils.openSession();
        session.beginTransaction();

       //通过get获得持久对象
        User u = (User) session.get(User.class, 3);//持久化状态


        session.evict(u);//此时变为游离
         u.setId(0);//此时变为瞬时

        session.getTransaction().commit();
        session.close();//游离状态


    }

    //游离=》持久
    //是否与session关联
    @Test
    public void fun7()
    {
        Session session = HivernateUtils.openSession();
        session.beginTransaction();

       //通过get获得持久对象
        User u = (User) session.get(User.class, 3);//持久化状态


        session.evict(u);//此时变为游离
         session.update(u); //将游离变为持久（此处不宜调用save,因为user已经有id了，不能再存储一个id相同的对象）

        session.getTransaction().commit();//打印update 语句，游离转持久
        session.close();//游离状态


    }
}
