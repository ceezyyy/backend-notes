# 17. 打印从1到最大的n位数

## 题目

输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

**示例 1:**

输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]

**说明：**

用返回一个整数列表来代替打印
n 为正整数



## 思路

这道题一开始考虑到了大数问题，因为限制条件没有说明 `n` 的范围（后来发现题目返回类型为 `int[]`）

思路比较简单，先求得最大的 n 位数，遍历，用整型数组保存结果作为返回值



## 题解

```java
package printNumbers;

class Solution {
    public int[] printNumbers(int n) {
        // initialization
        int target = 0;
        // get target
        while (n > 0) {
            target = target * 10 + 9;
            n--;
        }
        int[] result = new int[target];
        // get result
        for (int i = 1; i <= target; i++) {
            result[i - 1] = i;
        }
        return result;
    }
}


// Time Complexity: O(10^n)
// Space Complexity: O(1)
```

