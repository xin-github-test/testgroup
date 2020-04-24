package demo;

import java.io.Serializable;
//类通过实现 java.io.Serializable 接口以启用其序列化功能
public class Book implements Serializable {
 private static final long serialVersionUID =1L;
 private String id;




    private String name ;
 public Book(){

 }
 public Book(String id,String name )
 {
     this.id=id;
     this.name=name;
 }
 public String getId(){
     return id;
 }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
