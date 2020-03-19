import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        /*
         * Primitive Reference
         * --------- ---------
         * byte      Byte
         * short     Short
         * int       Integer
         * long      Long
         * float     Float
         * double    Double
         * char      Character
         * boolean   Boolean
         * */
        ArrayList<Integer> array = new ArrayList<>();
        System.out.println(array);
        array.add(100);
        System.out.println(array);

        boolean success = array.add(200);
        System.out.println(success);

        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(new Random().nextInt(33));  // 左闭右开
        }
        System.out.println(list);
    }
}
