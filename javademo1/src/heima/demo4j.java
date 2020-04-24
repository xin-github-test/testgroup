package heima;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;


public class demo4j {
        //测试类，不用创建main函数就可以直接对类进行测试
     public void test1() throws DocumentException {
       SAXReader reader=new SAXReader(); //创建一个xml的解析对象
       Document document=reader.read("src/Book.xml");//把xml文档加载到document对象中
       Element root=document.getRootElement();
       /* Element bookNode= root.element("书");
         System.out.println(bookNode.getName());*/
       List list=root.elements();  //该方法返回一个list集合,得到当前节点的所有子节点
        Element sb=(Element) list.get(1); //获取该集合的第二个元素
        String name =sb.element("书名").getText();
        System.out.println(name);

     }
    @Test  //测试类  要求：不能有参数和返回值，里面有一个断言方法Assert..assertEquals(参数1，参数2）；参数一为期待值，后面为需要测试的方法，若方法得出的值与期待值一样就不会报错，反之报错
    public void test2() throws DocumentException {
        SAXReader reader = new SAXReader(); //创建一个xml的解析对象
        Document document = reader.read("src/Book.xml");//把xml文档加载到document对象中
        Element root = document.getRootElement();//获取根节点
           treeWalk(root);  //递归调用获取子节点
    }
    public void treeWalk(Element ele)
    {
        System.out.println(ele.getName());//输出每个元素的名称
        for(int i=0;i<ele.nodeCount();i++)//获取改节点下的子节点的个数
        {
           Node node= ele.node(i);//取出该节点下的子节点
             if(node instanceof  Element)  //判断当前节点是否为标签（因为节点不只有标签，文档中的各个部分都可以是节点））
             {
                 treeWalk((Element)node);//继续获取该节点下的子节点
             }
        }



    }
}
