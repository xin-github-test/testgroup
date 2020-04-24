package ActionContext;

import ActionContext.domain.Student;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * s:iterator 标签的使用
 *
 */
public class Demo4Action extends ActionSupport {
private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String findAll()
   {
       students=new ArrayList<>();
       students.add(new Student("张三",18));
       students.add(new Student("李四",19));
       students.add(new Student("王五",20));
       return SUCCESS;
   }

}
