# 30. 包含 min 函数的栈

## 题目

定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

 

**示例:**

```java
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.
```



**提示：**

各函数的调用总次数不超过 20000 次



## 思路

这题的关键点就在于如何快速获取栈中的最小值

若只使用单一变量记录最小值，则当该变量弹出栈时，我们无法获取第二小的元素，此思路不通

除了普通栈之外，需借助辅助栈。

栈的特点是先进先出，辅助栈的作用是栈顶永远存储着栈中最小的元素，通过 `peek()` 可以在 `O(1)` 时间内获取元素

对于后进栈的元素：

若该元素比栈顶元素小或者相等：进辅助栈（位于栈顶），当该元素弹出栈时，也弹出辅助栈

若该元素比栈顶元素大：舍弃，因为我们只关心最小的元素



## 题解

```java
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
```



## 总结

1. 多刷题，一些集合函数的方法太久不用会模糊
2. `Stack` 中存储的数据是包装类型，判断是否相等必须要用 `equals()`