package com.company.domain;

public class Emp {
    private Integer id;
    private String name;
    private String gender;
    private Double salary;
    private String come;
    private Integer dept_id;

    public Emp() {
    }

    public Emp(Integer id, String name, String gender, Double salary, String come, Integer dept_id) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.come = come;
        this.dept_id = dept_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getCome() {
        return come;
    }

    public void setCome(String come) {
        this.come = come;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", come='" + come + '\'' +
                ", dept_id=" + dept_id +
                '}';
    }
}
