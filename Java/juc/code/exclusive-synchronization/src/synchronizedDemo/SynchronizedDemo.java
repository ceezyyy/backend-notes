package synchronizedDemo;

public class SynchronizedDemo {

    public synchronized void func() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
    }

}
