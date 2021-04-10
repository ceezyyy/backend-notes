import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 自定义线程池
 * </p>
 *
 * @author ceezyyy
 * @since 2021/4/10
 */
@Slf4j
public class ThreadPool {

    // 阻塞队列
    private BlockedQueue<Runnable> blockedQueue;

    // 阻塞队列容量
    private int queueCapacity;

    // 核心线程数量 (控制并发度)
    private int coreSize;

    // 当前线程集合, 初始为空 (共享资源)
    private Set<Worker> workers = new HashSet<>();

    // 超时限制
    private long timeout;
    private TimeUnit unit;

    public ThreadPool(int queueCapacity, int coreSize, long timeout, TimeUnit unit) {
        this.queueCapacity = queueCapacity;
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.unit = unit;
        this.blockedQueue = new BlockedQueue<>(queueCapacity);
    }

    // 线程包装类
    class Worker extends Thread {
        private Runnable task;

        public Worker(Runnable task) {
            this.task = task;
        }

        /*
          worker 执行逻辑:
          1) task 不为空 -> 执行 task
          2) task 为空 -> 从 blockedQueue 获取任务
          3）都为空 -> 从线程集合移除
         */
        @Override
        public void run() {
            // 不断获取任务
            while (task != null || (task = blockedQueue.poll(timeout, unit)) != null) {
                try {
                    task.run();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    task = null;
                }
            }
            // 从线程集合移除该线程
            synchronized (workers) {
                workers.remove(this);
            }
        }
    }

    /**
     * 执行任务
     * 1) 当前 workers < coreSize: 创建新的 worker
     * 2) 当前 workers >= coreSize: 进入阻塞队列
     *
     * @param task 当前任务
     */
    public void execute(Runnable task) {
        synchronized (workers) {
            if (workers.size() < coreSize) {
                // 用到时才创建
                Worker worker = new Worker(task);
                workers.add(worker);
                log.info("{} 任务开启", task);
                worker.start();
            } else {
                blockedQueue.offer(task, 1000, TimeUnit.MILLISECONDS);
            }
        }
    }

}
