package daemonThread;

public class App {

    public static void main(String[] args) {

        // Daemon thread
        Thread task = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");

        task.setDaemon(true);
        task.start();

        System.out.println("Main thread exited");

    }

}
