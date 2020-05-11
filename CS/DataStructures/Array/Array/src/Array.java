public class Array {
    private int[] data;
    private int size;

    public Array() {
        /**
         * Description: constructor with default capacity 10
         * @param: []
         * @return:
         */
        this(10);
    }


    public Array(int capacity) {
        /**
         * Description: constructor with capacity
         * @param: [capacity]
         * @return:
         */
        data = new int[capacity];
        size = 0;
    }


    public int getSize() {
        /**
         * Description: get the size of array
         * @param: []
         * @return: int
         */
        return size;
    }

    public boolean isEmpty() {
        /**
         * Description: whether the array is empty
         * @param: []
         * @return: boolean
         */
        return size == 0;
    }

    public int getCapacity() {
        /**
         * Description: get the capacity of array
         * @param: []
         * @return: int
         */
        return data.length;
    }

    public void add(int index, int element) throws IllegalAccessException {
        /**
         * Description: add element to array
         * @param: [index, element]
         * @return: void
         */

        // corner case
        if (size == data.length) throw new IllegalArgumentException("array is full");
        if (index < 0 || index >= data.length) throw new IllegalAccessException("index out of bounds");

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
    }

    public void addFirst(int element) throws IllegalAccessException {
        /**
         * Description: add  element to the front of array
         * @param: [element]
         * @return: void
         */
        add(0, element);
    }

    public void addLast(int element) throws IllegalAccessException {
        /**
         * Description: add element to the tail of array
         * @param: [element]
         * @return: void
         */
        add(size, element);
    }
}
