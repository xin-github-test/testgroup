package heima;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class Xpath {
    @Test
    public void test() throws DocumentException {

        SAXReader read = new SAXReader();
        Document document = read.read("src/Book.xml");
        Node node = document.selectSingleNode("/书架/书[2]/书名");//选择单个标签，选择书架标签下的第二个书标签里面的书名标签
        System.out.println(node.getText()); //获取该标签节点下的内容
    }
    @Test
    public void test2() throws DocumentException {

        SAXReader read = new SAXReader();
        Document document = read.read("src/Book.xml");
        List list= document.selectNodes("//*");//  "//*"代表该节点下的所有子节点，不记深度（即子节点下的子节点也会被取出）若写成"/*"代表该节点下的子节点，而子节点下的子节点不会访问）
        for(int i=0;i<list.size();i++)
        {
            Node node=(Node)list.get(i);
            System.out.println(node.getName()+"\t"+node.getText());
        }

    }

}
