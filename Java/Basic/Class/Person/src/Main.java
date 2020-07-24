public class Main {

    public static void main(String[] args) {
        Person person = new Person();
        person.name = "Mike";
        person.setAge(22);
        System.out.println(person.getAge());
        person.show();
    }
}
