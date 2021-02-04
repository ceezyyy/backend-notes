package searching.linearSearch;

/**
 * Linear search
 */
public class LinearSearch {

    private LinearSearch() {
    }

    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target))
                return i;
        }
        return -1;
    }

}
