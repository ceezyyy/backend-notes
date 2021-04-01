/**
 * <p>
 * 栈帧 debug
 * </p>
 *
 * @author ceezyyy
 * @since 2021/4/1
 */
public class App {
    public static void main(String[] args) {
        method1(666);
    }

    public static void method1(int x) {
        System.out.println(x);
        method2(x);
    }

    public static int method2(int x) {
        return x;
    }

}
