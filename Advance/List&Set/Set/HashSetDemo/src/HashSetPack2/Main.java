package HashSetPack2;


import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // 用 HashSet 存储自定义类时 必须重写 equals 和 hashcode 方法
        Person p1 = new Person("LBJ", 22);
        Person p2 = new Person("LBJ", 22);

        HashSet<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2);

        System.out.println(set);  // p1 p2 地址不相同
        for (Person p : set) {
            System.out.println(p.toString());  // 没有重写 toString 方法
        }

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));


    }


}


