import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        /*
         * 1. public static String toString(array)
         * 2. public static void sort()
         * */
        int[] array = {189, 45, 4, 78, 8, 989, 5, 476, 731, 6, 46};
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        String[] stringArray = {"aa", "bb", "c", "ccc", "ee"};
        Arrays.sort(stringArray);
        System.out.println(Arrays.toString(stringArray));
    }
}
