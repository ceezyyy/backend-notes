public class Person {
    private String name;
    private static int a = 1;

    public Person(String name) {
        this.name = name;
    }

    public void sayHi() {
        System.out.println("My name is " + name);
    }
}
