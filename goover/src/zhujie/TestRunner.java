package zhujie;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        //查看测试类中的方法，哪一个有@Mytest注解就运行哪一个方法

        //得到要执行类的Class对象
        //test1();
        Class clazz = SomeDaoImpl.class;
        Method[] methods = clazz.getMethods();
        for (Method m :
                methods) {
            //得到当前方法上的注解对象
            MyTest myTest = m.getAnnotation(MyTest.class);
            if (myTest != null) //如果有注解
            {
                long timeout = myTest.Timeout();//获取注解上的数据
                if (timeout < 0)//不需要测试

                {
                    m.invoke(clazz.newInstance(), null);
                } else {  //需要测试

                    long l1 = System.nanoTime();//得到纳秒值
                    m.invoke(clazz.newInstance(), null);
                    long l2 = System.nanoTime();
                    if (l2 - l1 > timeout) {
                        System.out.println(m.getName() + "方法超时了！");
                    }
                }
            }

        }
    }

    private static void test1() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz= SomeDaoImpl.class;
        //得到类中的方法，包括本类和父类中所有公共的方法
        Method[] methods=clazz.getMethods();
        //遍历所有的方法
        for (Method m:methods
             ) {
            boolean isExistsAnno=m.isAnnotationPresent(MyTest.class);
            //判断哪一个方法有相应的注解
            if(isExistsAnno)
            {
                m.invoke(clazz.newInstance(),null);
            }
        }
    }
}
