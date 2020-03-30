public class Main {

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        // 开启线程
        thread.start();
        for (int i = 0; i < 30; i++) {
            System.out.println("Main" + i);
        }
    }
}
