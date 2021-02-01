import java.util.Deque;
import java.util.LinkedList;

/**
 * A demo of Object.wait() & Object.notify()
 *
 * @param <E>
 */
public class BlockingQueue<E> {

    private int capacity;
    private Deque<E> deque = new LinkedList<>();

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(E element) throws InterruptedException {

        while (deque.size() == capacity) {
            wait();
        }

        deque.add(element);
        notifyAll();

    }

    public synchronized E get() throws InterruptedException {

        while (deque.isEmpty()) {
            wait();
        }

        E res = deque.remove();
        notifyAll();
        return res;

    }
}
