
public class Person {
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "I'm overrode";
    }

    @Override
    public boolean equals(Object obj) {
        // 多态的弊端
        // 向下转型
        if (obj instanceof Person) {
            Person object = (Person) obj;
            return this.name == object.name && this.age == object.age;
        }
        return false;
    }
}


