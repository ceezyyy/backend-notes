public class Main {

    public static void main(String[] args) {
        Person[] person = new Person[3];
        person[0] = new Person("LBJ", 35);
        person[1] = new Person("AD", 28);
        person[2] = new Person("Crusol", 29);

        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i]);
            System.out.println(person[i].getName());
        }

    }
}
