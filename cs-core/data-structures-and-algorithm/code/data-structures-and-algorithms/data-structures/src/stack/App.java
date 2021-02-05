package stack;

public class App {

    public static void main(String[] args) {

        Stack<Integer> stack = new ArrayStack<>();

        stack.push(3);
        stack.push(2);
        stack.push(1);

        System.out.println(stack.isEmpty());  // false

        System.out.println(stack.peek());  // 1

        System.out.println(stack.toString());  // Stack: {size = 3, [ 3, 2, 1 ]}

        System.out.println(stack.pop());  // 1

        System.out.println(stack.peek());  // 2

        System.out.println(stack.toString());  // Stack: {size = 2, [ 3, 2 ]}

        System.out.println(stack.getSize());  // 2

    }

}
