public class Main {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        printArray(array);
    }

    public static void printArray(int[] array) {  // address
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
