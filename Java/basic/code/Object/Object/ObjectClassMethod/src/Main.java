public class Main {
//    Object
//    java.lang.Object

    public static void main(String[] args) {
        Person person = new Person("LBJ", 22);
        String string = person.toString();
        System.out.println(string);  // Person@2d98a335

        // 直接print对象 == 直接调用对象的toString方法
        System.out.println(person);  // Person@2d98a335

//        public boolean equals(Object obj) {
//            return this == obj;
//        }
        Person person1 = new Person("AD", 23);
        Person person2 = new Person("LBJ", 22);
        System.out.println(person.equals(person1));
        System.out.println(person.equals(person2));

    }
}
