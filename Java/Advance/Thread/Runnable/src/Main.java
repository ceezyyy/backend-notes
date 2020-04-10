public class Main {

    /* 创建多线程的第二种方式 -> 实现 Runnable 接口*/
    public static void main(String[] args) {
        RunnableImpl impl = new RunnableImpl();
        Thread thread = new Thread(impl);
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("Main" + i);
        }
    }
}
