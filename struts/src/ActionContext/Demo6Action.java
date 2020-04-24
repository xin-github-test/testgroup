package ActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 *  s:checkboxlist标签的使用
 *
 */
public class Demo6Action extends ActionSupport {
  //初始化表单用的爱好列表
     private String [] hobbyarr =new String[]{"吃饭","睡觉","写代码"};
     //用户提交表单时的数据封装到此属性中
     private String hobby;

    public String[] getHobbyarr() {
        return hobbyarr;
    }

    public void setHobbyarr(String[] hobbyarr) {
        this.hobbyarr = hobbyarr;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String save()
    {
        System.out.println(hobby);
        return null;
    }
}
