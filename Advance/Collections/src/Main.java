import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * 此类完全由在 collection 上进行操作或返回 collection 的静态方法组成。
 * 它包含在 collection 上操作的多态算法，即“包装器”，
 * 包装器返回由指定 collection 支持的新 collection，以及少数其他内容。
 * */


public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        // public static <T> boolean addAll(Collection<? super T> c, T... elements)
        Collections.addAll(list, 1, 2, 3, 4, 5);
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);

        Collections.sort(list);

        Person p1 = new Person("LBJ", 22);
        Person p2 = new Person("AD", 23);
        System.out.println(p1);
        System.out.println(p2);

        List<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);

        Collections.sort(people);
        System.out.println(people);
    }
}
