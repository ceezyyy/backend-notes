/**
 * <p>
 * synchronized 计数器
 * </p>
 *
 * @author ceezyyy
 * @since 2021/4/3
 */
public class Counter {

    // 类变量
    private static int counter;

    public void increase() {
        synchronized (Counter.class) {
            counter++;
        }
    }

    public void decrease() {
        synchronized (Counter.class) {
            counter--;
        }
    }

    public int getCounter() {
        synchronized (this) {
            return counter;
        }
    }

}
