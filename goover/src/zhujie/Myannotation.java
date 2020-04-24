package zhujie;
//创建一个注解类（注解本身就是一个接口，继承Annotation,但是不能直接写extends）
//且只能定义属性
public @interface Myannotation {
   int age1();
   /*  public int age();
    public static final String name="";*///可以定义常量
}
