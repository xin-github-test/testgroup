package demo2.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import demo2.domain.Student;

public class StudentAction  extends ActionSupport implements ModelDriven<Student> {
     private Student student=new Student();


     public String addStudent()
     {
         String key = getText("key");
         System.out.println(key);
         return SUCCESS;
     }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public Student getModel() {
        return student;
    }
}
