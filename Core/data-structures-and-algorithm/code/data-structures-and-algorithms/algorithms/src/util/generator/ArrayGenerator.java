package util.generator;

/**
 * Generate Integer array
 */
public class ArrayGenerator {

    private ArrayGenerator() {
    }

    public static Integer[] autogenerate(int n) {
        Integer[] res = new Integer[n];
        for (int i = 0; i < n; i++) {
            res[i] = i;
        }
        return res;
    }

}
