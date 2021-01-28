package util.generator;

import java.util.Random;

/**
 * Generate Integer array
 */
public class ArrayGenerator {

    private ArrayGenerator() {
    }

    public static Integer[] autogenerate(int n) {
        Integer[] res = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            res[i] = random.nextInt(100);
        }
        return res;
    }

}
