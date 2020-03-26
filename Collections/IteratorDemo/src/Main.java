import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        // 多态
        Collection<String> pool = new ArrayList<>();
        pool.add("LBJ");
        pool.add("AD");
        pool.add("GOAT");
        pool.add("KUZ");
        pool.add("Mc");
        System.out.println(pool);

        // iterator() 获取迭代器的实现类对象，使用Iterator<>接口接收（多态）
        // 获取迭代器的实现类对象
        // 将指针指向 -1 索引
        Iterator<String> it = pool.iterator();

        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }

        for (String s : pool) {
            System.out.println(s);
        }
    }
}
