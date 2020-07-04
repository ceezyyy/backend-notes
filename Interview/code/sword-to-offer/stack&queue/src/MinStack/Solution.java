package MinStack;

import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */

    public MinStack() {
        // the real stack
        stack = new Stack<>();
        // keep tracking of the min element
        minStack = new Stack<>();
    }

    public void push(int x) {
        // push x to stack
        stack.push(x);
        // if minStack is empty
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            // push x to minStack
            if (minStack.peek() >= x) {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        // if stack is empty
        if (stack.isEmpty()) return -1;
        return stack.peek();
    }

    public int min() {
        // if minStack is empty
        if (minStack.isEmpty()) return -1;
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */