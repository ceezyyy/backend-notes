public class Main {

    public static void main(String[] args) {
        /*
         * 1. import Class
         * 2. new a entity
         * 3. method / attribute
         */

        Student student = new Student();
        System.out.println(student.name);  // default value: null
        System.out.println(student.age);  // default value: 0
        student.eat();
        student.learn();
        student.sleep();
        student.name = "Mike";
        student.age = 22;
        System.out.println(student.name);
        System.out.println(student.age);
    }
}
