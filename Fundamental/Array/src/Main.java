public class Main {

    public static void main(String[] args) {
        int[] array = new int[3];
        System.out.println(array);  // address
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        array[1] = 100;
        array[2] = 200;
        System.out.println(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
