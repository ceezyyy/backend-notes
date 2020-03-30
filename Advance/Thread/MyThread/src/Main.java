public class Main {

    public static void main(String[] args) {
        // 3个新线程
        MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        // 开启 3 个（我们创建的）线程
        myThread.start();
        myThread1.start();
        myThread2.start();

        // 获取当前正在执行线程的名字
        System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < 10; i++) {
            /* 在指定的毫秒数内让当前正在执行的线程休眠（暂停执行）*/
            // 需要 用 try catch 语句
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }

    }
}
