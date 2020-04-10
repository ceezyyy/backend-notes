package reflectdemo1;


public class Student {
    private String name;
    private int number;
    public int a;
    protected int b;
    int c;


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Student(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public Student() {
    }
}



