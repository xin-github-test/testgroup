package zhujie;

public class SomeDaoImpl {

    @MyTest(Timeout = 1000) //自己定义的标记注解
    public void testAdd()
    {
        System.out.println("add方法执行了");
    }


    public void testUpdate()
    {
        System.out.println("testUpdate方法执行了");
    }

}
