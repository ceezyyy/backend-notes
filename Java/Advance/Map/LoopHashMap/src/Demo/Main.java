package Demo;


import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Person> map = new HashMap<>();
        map.put(0, new Person("a", 1));
        map.put(1, new Person("b", 2));
        map.put(2, new Person("c", 3));
        map.put(3, new Person("d", 4));
        map.put(3, new Person("e", 5));  // overlap

        for (Map.Entry<Integer, Person> set : map.entrySet()) {
            System.out.println(set);
        }

        // 要重写 hashCode 和 equals 方法
        Map<Person, Integer> map1 = new HashMap<>();
        map1.put(new Person("a", 1), 0);
        map1.put(new Person("a", 1), 0);
        map1.put(new Person("a", 1), 0);

        for (Map.Entry<Person, Integer> set : map1.entrySet()) {
            System.out.println(set);
        }
    }
}

