package reflect;


import domain.Person;

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException {

        /*
         * 获取 class 对象的三种方式
         *
         * */

        Class cls1 = Class.forName("domain.Person");
        System.out.println(cls1);

        Class cls2 = Person.class;
        System.out.println(cls2);

        Person person = new Person();
        Class cls3 = person.getClass();
        System.out.println(cls3);

        System.out.println(cls1 == cls2);
        System.out.println(cls1 == cls3);
        System.out.println(cls2 == cls3);
    }
}



