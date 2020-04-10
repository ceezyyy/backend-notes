

public class MyThread extends Thread {
    // 重写 run 方法 （需要线程做什么）
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println("My thread" + i);
        }
    }
}



