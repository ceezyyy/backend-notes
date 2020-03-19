
public class Person {
    String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;  // "this"
        } else {
            System.out.println("Age cannot be negative!");
        }
    }

    public void show() {
        System.out.println("My name is " + name + ", I'm " + Integer.toString(age) + " now");

    }
}

