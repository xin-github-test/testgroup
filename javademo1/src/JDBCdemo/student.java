package JDBCdemo;

public class student {
    @Override
    public String toString() {
        return "student{" +
                "stuid=" + stuid +
                ", stuname='" + stuname + '\'' +
                '}';
    }

    private int stuid;
    private String stuname;

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

}
