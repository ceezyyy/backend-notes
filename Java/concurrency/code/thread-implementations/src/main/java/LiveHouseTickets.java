import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LiveHouseTickets implements Runnable{

    private int ticket = 5;

    public void run() {
        while (true) {

            if (ticket <= 0) break;

            log.info(Thread.currentThread().getName() + " is buying no." + ticket + " ticket");
            ticket--;

        }
    }

    public static void main(String[] args) {
        new Thread(new LiveHouseTickets()).start();
        new Thread(new LiveHouseTickets()).start();
        new Thread(new LiveHouseTickets()).start();
    }

}

