public class App {
    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.currentThread().getName() + " started");

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }, "t1");

        t1.start();
        t1.join();

        System.out.println(Thread.currentThread().getName() + " exited");

    }
}
