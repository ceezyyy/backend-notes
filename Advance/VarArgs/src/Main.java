public class Main {

    public static void main(String[] args) {
        int result = add(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(result);

        addPro("abc", 1, 2, 3, 's', 8.8);

    }

    private static int add(int... k) {
        int result = 0;
        for (int i : k) {
            result += i;
        }
        System.out.println(k.length);
        return result;
    }

    private static void addPro(Object... objects) {
        for (Object o : objects) {
            System.out.println(o);
        }

    }
}
