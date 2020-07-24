public class Main {

    public static void main(String[] args) {
        int[] array = new int[2];
        array[0] = 0;
        array[1] = 1;

        try {
            array[2] = 100;
        } catch (Exception e) {
            System.out.println(e);
        }

        int[] testArray = new int[1024 * 1024 * 1024];  // java.lang.OutOfMemoryError
        System.out.println("testing");


    }
}
