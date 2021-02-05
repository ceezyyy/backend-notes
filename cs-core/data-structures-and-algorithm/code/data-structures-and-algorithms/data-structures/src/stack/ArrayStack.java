package stack;

import array.DynamicArray;

public class ArrayStack<E> implements Stack<E> {

    private DynamicArray<E> data;

    public ArrayStack() {
        this.data = new DynamicArray<>();
    }

    public ArrayStack(int capacity) {
        this.data = new DynamicArray<>(capacity);
    }

    @Override
    public E peek() {

        if (data.isEmpty()) return null;

        return data.get(data.getSize() - 1);

    }

    @Override
    public void push(E e) {

        data.addLast(e);

    }

    @Override
    public E pop() {

        return data.removeLast();

    }

    @Override
    public boolean isEmpty() {

        return data.isEmpty();

    }

    @Override
    public int getSize() {

        return data.getSize();

    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Stack: {size = %d, [ ", data.getSize()));
        for (int i = 0; i < data.getSize(); i++) {
            sb.append(data.get(i));
            if (i != data.getSize() - 1)
                sb.append(", ");
        }
        sb.append(" ]}");

        return sb.toString();

    }
}
