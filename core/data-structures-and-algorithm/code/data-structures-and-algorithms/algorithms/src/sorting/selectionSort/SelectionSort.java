package sorting.selectionSort;

/**
 * Selection sort
 *
 * @author ceezyyy
 */
public class SelectionSort {

    private SelectionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {

        int minIndex;
        int n = data.length;

        /**
         * Select what? -> the minimum element from the unsorted collection
         * data[0, i) -> sorted
         * data[i, n) -> not sorted
         */
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                minIndex = i;
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
                swap(data, i, minIndex);
            }
        }
    }

    private static <E extends Comparable<E>> void swap(E[] data, int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

}


// Time: O(n^2)
// Space: O(1)
