

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(this.getName());  // 获取当前线程的名字
    }
}



