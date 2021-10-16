package array;

/**
 * Dynamic Array
 *
 * @author ceezyyy
 */
public class DynamicArray<E> {

    // The number of elements in array
    // Index of the element to be stored
    private int size;
    private E[] data;
    private static final int SCALE_FACTOR = 2;

    public DynamicArray() {
        this(10);
    }

    public DynamicArray(int capacity) {
        if (capacity <= 0)
            this.data = (E[]) new Object[10];
        else
            this.data = (E[]) new Object[capacity];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Add an element to the specific index
     *
     * @param index
     * @param element
     */
    public void add(int index, E element) {

        if (size == data.length)
            resize();

        if (index < 0 || index > size)
            throw new IllegalArgumentException("add() failed! Require index >= 0 or index <= size");

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = element;
        size++;

    }

    /**
     * Add an element to the beginning of the array
     *
     * @param element
     */
    public void addFirst(E element) {
        add(0, element);
    }

    /**
     * Add an element to the end of the array
     *
     * @param element
     */
    public void addLast(E element) {
        add(size, element);
    }

    /**
     * Expansion the array
     */
    private void resize() {

        int newCapacity = SCALE_FACTOR * data.length;
        E[] newData = (E[]) new Object[newCapacity];

        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }

        // Let GC
        this.data = null;

        this.data = newData;

    }

    /**
     * Get element by index
     *
     * @param index
     * @return
     */
    public E get(int index) {

        if (index < 0 || index >= size)
            throw new IllegalArgumentException("get() failed! Required index >= 0 or index < size!");

        return data[index];

    }

    /**
     * Whether or not this array contains the given element
     *
     * @param element
     * @return
     */
    public boolean contains(E element) {

        if (element == null) return false;

        for (int i = 0; i < size; i++) {
            if (element.equals(data[i]))
                return true;
        }

        return false;

    }

    /**
     * Find the element by index
     * return the index of its first occurrence
     *
     * @param element
     * @return
     */
    public int find(E element) {

        if (element != null) {
            for (int i = 0; i < size; i++) {
                if (element.equals(data[i]))
                    return i;
            }
        }

        // Not found or the element is null
        return -1;

    }

    /**
     * Update the value of the element by index
     *
     * @param index
     * @param element
     */
    public void set(int index, E element) {

        if (index < 0 || index >= size)
            throw new IllegalArgumentException("set() failed! Required index >= 0 or index < size!");

        data[index] = element;

    }

    /**
     * Remove the element by index
     *
     * @param index
     * @return
     */
    public E remove(int index) {

        if (index < 0 || index >= size)
            throw new IllegalArgumentException("remove() failed! Required index >= 0 or index < size!");

        E res = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;

        return res;

    }

    /**
     * Remove the element by value
     *
     * @param element
     * @return
     */
    public E removeByVal(E element) {

        int index = find(element);

        if (index == -1)
            throw new IllegalArgumentException("removeByVal() failed! Element not found!");

        return remove(index);

    }

    /**
     * Remove the first element
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * Remove the last element
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Array: {size = %d, capacity = %d, [ ", size, data.length));
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1)
                sb.append(", ");
        }
        sb.append(" ]}");

        return sb.toString();

    }
}
