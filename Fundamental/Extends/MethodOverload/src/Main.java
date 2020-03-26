public class Main {
    /* overload */
    public static void main(String[] args) {
        System.out.println(sum(100, 100));
        System.out.println(sum(100, 100, 100));
        System.out.println(sum(100, 100, 100, 100));
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int sum(int a, int b, int c) {
        return a + b + c;
    }

    public static int sum(int a, int b, int c, int d) {
        return a + b + c + d;
    }
}
