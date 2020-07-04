# 10- I. 斐波那契数列

## 题目

写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：

```mathematica
F(0) = 0,   
F(1) = 1
F(N) = F(N - 1) + F(N - 2),  N > 1.
```



斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

 

**示例 1：**

输入：n = 2
输出：1

**示例 2：**

输入：n = 5
输出：5

**提示：**

0 <= n <= 100



## 思路

第一反应就是 `dp`，看到每项之间都有依赖关系，用 `dp` 可以避免重复计算

开辟一个大小为 `n + 1` 的数组用来保存结果



## 题解

```java
package fib;

class Solution {
    public int fib(int n) {
        // initialization
        int[] fibArray = new int[n + 1];
        // corner case
        if (n == 0) return 0;
        if (n == 1) return 1;
        // dp
        fibArray[0] = 0;
        fibArray[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            fibArray[i] = (fibArray[i-1] + fibArray[i-2]) % 1000000007;
        }
        return fibArray[n];
    }
}


// Time Complexity: O(n)
// Space Complexity: O(n)
```



