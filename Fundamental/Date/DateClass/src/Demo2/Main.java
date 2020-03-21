package Demo2;

public class Main {
    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 1000000; i++) {
//            System.out.println(i);
//        }
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);

        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};
        System.arraycopy(a, 0, b, 2, 2);
        System.out.println(b);
    }
}



