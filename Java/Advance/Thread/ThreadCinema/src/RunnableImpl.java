

public class RunnableImpl implements Runnable {
    int ticket = 2 ;

    @Override
    public void run() {
        while (ticket > 0) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is selling NO." + ticket + " tickets");
            ticket--;

        }
    }
}


