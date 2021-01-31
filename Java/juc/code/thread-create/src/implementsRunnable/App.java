package implementsRunnable;

public class App {

    public static void main(String[] args) {

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " here!");
        }, "t1").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " here!");
        }, "t2").start();

        System.out.println(Thread.currentThread().getName() + " here!");

    }

}
