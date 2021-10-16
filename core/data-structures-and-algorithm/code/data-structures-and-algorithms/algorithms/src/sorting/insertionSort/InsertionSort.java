package sorting.insertionSort;

/**
 * Insertion sort
 *
 * @author ceezyyy
 */
public class InsertionSort {

    private InsertionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {

        int n = data.length;

        /**
         * Where to insert? -> find the right place in the sorted collection for data[i]
         * data[0, i) -> sorted
         * data[i, n) -> unsorted
         */
        for (int i = 0; i < n; i++) {
            E current = data[i];
            int j;
            for (j = i; j - 1 >= 0 && data[j - 1].compareTo(current) > 0; j--) {
                // An optimization of swap
                data[j] = data[j - 1];
            }
            // We've find the right place "j"
            data[j] = current;
        }
    }

}


// Time: O(n^2), if the array is sorted -> O(n)
// Space: O(1)
