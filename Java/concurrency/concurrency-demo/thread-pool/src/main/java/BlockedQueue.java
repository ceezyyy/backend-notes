import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * 自定义阻塞队列
 * </p>
 *
 * @author ceezyyy
 * @since 2021/4/10
 */
@Slf4j
public class BlockedQueue<E> {

    // 阻塞队列底层数据结构 -> 双向链表
    private Deque<E> data;

    // 容量 -> 内存有限
    private int capacity;

    // 锁 -> 保护临界区
    private ReentrantLock lock = new ReentrantLock();

    // waitSet
    private Condition fullWaitSet = lock.newCondition();
    private Condition emptyWaitSet = lock.newCondition();

    public BlockedQueue(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayDeque<>(capacity);
    }

    /**
     * 任务进入阻塞队列
     *
     * @param task    当前任务
     * @param timeout 超时时间
     * @param unit    时间单元
     * @return
     */
    public boolean offer(E task, long timeout, TimeUnit unit) {
        lock.lock();
        try {
            // 剩余存活时间
            long ttl = unit.toNanos(timeout);

            while (data.size() == capacity) {
                // 超时
                if (ttl <= 0) return false;
                try {
                    log.info("阻塞队列满");
                    ttl = fullWaitSet.awaitNanos(ttl);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            data.add(task);
            log.info("{} 进入阻塞队列", task);
            emptyWaitSet.signal();
            return true;

        } finally {
            lock.unlock();
        }
    }

    /**
     * 从阻塞队列获取任务
     *
     * @param timeout 超时时间
     * @param unit    时间单元
     * @return
     */
    public E poll(long timeout, TimeUnit unit) {
        lock.lock();
        try {
            long ttl = unit.toNanos(timeout);

            while (data.isEmpty()) {
                if (ttl <= 0) {
                    log.info("获取任务超时");
                    return null;
                }
                try {
                    log.info("阻塞队列为空");
                    ttl = emptyWaitSet.awaitNanos(ttl);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            E e = data.poll();
            log.info("获取任务 {} 成功", e);
            fullWaitSet.signal();
            return e;

        } finally {
            lock.unlock();
        }
    }


}
