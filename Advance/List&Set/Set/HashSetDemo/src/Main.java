import java.util.HashSet;
import java.util.Set;

public class Main {

    /*
     * Set 接口的特点 implements Collection
     * 1. 不允许重复
     * 2. 没有索引
     *
     *
     * HashSet 接口 implements Set
     * 除此之外
     * 1. 无序
     * 2. 底层 HashMap 实现 (查询速度非常快)
     * */

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(4);
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(3);
        System.out.println(set);

        for (int i : set) {
            System.out.println(i);
        }

    }
}
