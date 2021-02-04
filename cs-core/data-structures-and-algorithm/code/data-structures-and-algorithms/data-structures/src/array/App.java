package array;

public class App {

    public static void main(String[] args) {

        DynamicArray<Integer> array = new DynamicArray<>(10);

        for (int i = 0; i < 20; i++) {
            array.add(i, i);
        }
        System.out.println(array);

        array.addFirst(88);
        System.out.println(array);

        array.addLast(10);
        System.out.println(array);

        array.set(array.getSize() - 1, 100);
        System.out.println(array);

        int index = array.find(99);
        System.out.println(index);

        boolean contains = array.contains(88);
        System.out.println(contains);

        boolean empty = array.isEmpty();
        System.out.println(empty);

        array.remove(array.getSize() - 1);
        System.out.println(array);

        array.removeFirst();
        System.out.println(array);

        array.removeLast();
        System.out.println(array);

        array.removeByVal(0);
        System.out.println(array);

    }

}
