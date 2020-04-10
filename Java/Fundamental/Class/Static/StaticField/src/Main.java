public class Main {

    public static void main(String[] args) {
        /* 静态变量 静态方法
         * 1. 静态不能直接访问非静态
         * “后人知道先人 而先人不知道后人”
         * 在内存中先有静态内容 后有非静态内容
         *
         * 2. static method 中不能使用关键字 “this”
         * 因为 this代表当前对象
         * */
        Student student1 = new Student("MIKE", 22);
        Student student2 = new Student("BABE", 19);

        System.out.println(student1.getName());
        System.out.println(student1.getAge());
        System.out.println(student2.getName());
        System.out.println(student2.getAge());

        student2.setRoom("666");
        System.out.println(student1.getRoom());

//      Recommended, Class. static variable
        System.out.println(Student.getRoom());  // static variable


        MyClass obj = new MyClass();
//      Recommended, Class.static method
        MyClass.methodStatic();
        obj.method();

    }
}
