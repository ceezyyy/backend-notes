public class Main {

    public static void main(String[] args) {
        RunnableImpl impl = new RunnableImpl();

        // 三个线程一起抢夺 CPU 执行权
        new Thread(impl).start();
        new Thread(impl).start();
        new Thread(impl).start();

    }
}
