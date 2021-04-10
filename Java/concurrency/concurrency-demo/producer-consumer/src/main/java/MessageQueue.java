import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * 自定义生产者 / 消费者模型
 * </p>
 *
 * @author ceezyyy
 * @since 2021/4/7
 */
@Slf4j
public class MessageQueue {

    // 容器, 双向链表
    private Deque<Msg> buffer = new ArrayDeque<>();
    // 容量
    private int capacity;

    public MessageQueue(int capacity) {
        this.capacity = capacity;
    }

    // 消费者（等待方）
    public Object get() {

        // 1. 获取对象的锁
        synchronized (buffer) {
            // 2. 如果条件不满足, 调用对象的 wait(), 被通知后仍要检查条件
            while (buffer.isEmpty()) {
                try {
                    buffer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 3. 满足条件则执行相应的逻辑
            log.info("Consuming");
            return buffer.removeFirst();
        }

    }

    // 生产者（通知方）
    public void put(Msg msg) {

        // 1. 获取对象的锁
        synchronized (buffer) {
            while (buffer.size() == capacity) {
                try {
                    buffer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.info("Producing");
            // 2. 改变条件
            buffer.push(msg);
            // 3. 通知所有等待在对象上的线程
            buffer.notifyAll();
        }

    }
}
