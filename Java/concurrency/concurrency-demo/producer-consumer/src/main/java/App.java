/**
 * <p>
 * 生产者 / 消费者测试类
 * </p>
 *
 * @author ceezyyy
 * @since 2021/4/7
 */
public class App {
    public static void main(String[] args) {

        MessageQueue messageQueue = new MessageQueue(5);

        // 消费者线程
        for (int i = 0; i < 2; i++) {
            int id = i;
            new Thread(() -> {
                messageQueue.get();
            }, "CONSUMER_" + i).start();
        }

        // 生产者线程
        for (int i = 0; i < 8; i++) {
            int id = i;
            new Thread(() -> {
                messageQueue.put(new Msg(id, id));
            }, "PRODUCER_" + i).start();
        }

    }
}
