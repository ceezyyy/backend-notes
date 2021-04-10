import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * WaitNotify 类
 * </p>
 *
 * @author ceezyyy
 * @since 2021/4/8
 */
public class WaitNotify {

    private static final Object LOCK = new Object();

    // 等待标记, 若标记符合则可以执行, 反之等待 (关键)
    private int flag;
    // for loop 次数
    private int loop;

    public WaitNotify(int flag, int loop) {
        // 初始值
        this.flag = flag;
        this.loop = loop;
    }

    /**
     * 交替输出逻辑代码
     *
     * @param id       当前线程 id
     * @param flag     当前标记 -> 控制顺序
     * @param nextFlag 下一个标记 -> 更新顺序
     */
    public void print(int id, int flag, int nextFlag) {

        // 交替打印的次数
        for (int i = 0; i < loop; i++) {

            synchronized (LOCK) {

                // 注意, 这里的 flag 为全局变量
                while (id != this.flag) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(id);
                // 更新顺序 (flag 为全局变量)
                this.flag = nextFlag;
                LOCK.notifyAll();

            }
        }
    }
}
