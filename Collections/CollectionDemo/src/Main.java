import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        Collection<Integer> pool = new ArrayList<>();
        System.out.println(pool);

        /* Add */
        pool.add(1);
        pool.add(1);
        pool.add(1);
        pool.add(2);
        pool.add(2);
        pool.add(3);

        System.out.println(pool);

        /* Remove */
        pool.remove(2);  // Remove Object not index
        System.out.println(pool);

        System.out.println(pool.isEmpty());
        System.out.println(pool.size());  // int

        // Object[] toArray();
        Object[] nums = pool.toArray();


    }
}
