package com.company;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        // Class.forName()
        Class class1 = Class.forName("com.company.Person");
        System.out.println(class1);

        // 类名.Class
        Class class2 = Person.class;
        System.out.println(class2);

        // 对象.getClass()
        Person person = new Person();
        Class class3 = person.getClass();
        System.out.println(class3);

        System.out.println(class1 == class2);  // true
        System.out.println(class1 == class3);  // true
        System.out.println(class2 == class3);  // true
    }
}
