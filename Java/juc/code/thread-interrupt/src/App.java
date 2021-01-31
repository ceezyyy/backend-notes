public class App {
    public static void main(String[] args) throws InterruptedException {

        Thread busyThread = new Thread(() -> {
            while (true) {
                // Do nothing
            }
        }, "Busy thread");

        Thread sleepThread = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Sleep thread");

        Thread.sleep(5000);

        busyThread.interrupt();
        sleepThread.interrupt();

        System.out.println("Sleep thread is interrupted: " + sleepThread.isInterrupted());
        System.out.println("Busy thread is interrupted: " + busyThread.isInterrupted());

        Thread.sleep(2000);

    }
}
