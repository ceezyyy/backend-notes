package stack;

/**
 * Stack
 *
 * @author ceezyyy
 */
public interface Stack<E> {

    /**
     * Look at the element at the top of this stack
     *
     * @return
     */
    E peek();

    /**
     * Push an element onto the top of this stack
     */
    void push(E e);

    /**
     * Remove the element at the top of this stack
     *
     * @return
     */
    E pop();

    /**
     * Test if this stack is empty
     *
     * @return
     */
    boolean isEmpty();

    /**
     * Get the size of this stack
     *
     * @return
     */
    int getSize();

}
