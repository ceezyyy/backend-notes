public class Main {

    public static void main(String[] args) {
        System.out.println(calculate(1, 2, 3));  // address
        System.out.println(calculate(1, 2, 3)[0]);  // value
        System.out.println(calculate(1, 2, 3)[1]);  // value

    }

    public static int[] calculate(int a, int b, int c) {
        int sum = a + b + c;
        int avg = (a + b + c) / 3;
        int[] res = {sum, avg};
        return res;  // return the address of the array
    }
}
