

public class RunnableImpl implements Runnable {
    /* 实现 run 方法 */
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println("My thread" + i);
        }
    }
}



