package ActionContext.domain;

import java.io.Serializable;
import java.util.Arrays;

public class Customer implements Serializable {
     private String name;
     private String password;
     private boolean married;
     private String[] hobby;

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    private String description;
     private String gender;

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", married=" + married +
                ", hobby=" + Arrays.toString(hobby) +
                ", description='" + description + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
