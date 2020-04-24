package heima;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class xpath_use {
    @Test
    public void test() throws DocumentException {

        SAXReader read = new SAXReader();
        Document document = read.read("src/Dom4jTest.xml");
       List list= document.selectNodes("/bookstore//book/title");
          for(int i=0;i<list.size();i++)
          {

              Node node=(Node)list.get(i);
              System.out.println(node.getText());

          }
    }
}