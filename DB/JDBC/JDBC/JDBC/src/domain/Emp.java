package domain;


import java.util.Date;

public class Emp {
    private int id;
    private String name;
    private String gender;
    private double salary;
    private Date come;
    private int dept_id;

    public Emp() {
    }

    public Emp(int id, String name, String gender, double salary, Date come, int dept_id) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.come = come;
        this.dept_id = dept_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getCome() {
        return come;
    }

    public void setCome(Date come) {
        this.come = come;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", come=" + come +
                ", dept_id=" + dept_id +
                '}';
    }
}



