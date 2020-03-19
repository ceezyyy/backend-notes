import java.util.Scanner;

public class Main {
    /*
     * Reference
     * 1. Import (excluding java.lang)
     * 2. Create class
     * 3. Use methods
     * */

    public static void main(String[] args) {
        // System.in -> Read from keyboard
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();
        System.out.println(result);
        String string = scanner.next();
        System.out.println(string);
    }
}
