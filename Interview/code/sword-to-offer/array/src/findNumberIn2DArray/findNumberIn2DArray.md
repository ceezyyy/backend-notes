#  04. 二维数组中的查找

## 题目

在一个 `n * m` 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

 

**示例:**

现有矩阵 matrix 如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]



给定 target = 5，返回 true。

给定 target = 20，返回 false。

 

**限制：**

0 <= n <= 1000

0 <= m <= 1000



## 思路

审题！审题！审题！

一开始看到有序就想着将二维转一维进行二分查找，后来发现审错题目了。

仔细审题发现：

**右上角：**

该行最大，该列最小



利用这个特征可以想到，在循环体内

若 `target` 大于当前值：当前行 + 1（列递增的特点）

若 `target` 小于当前值：当前列 - 1（行递减的特点）

若 `target` 等于当前值，直接返回 `true`

边界为数组内部，最终返回 `false`（没找到）

## 题解

```java
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // corner case
        if (matrix.length < 1 || matrix[0].length < 1) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        // top-right corner
        int currentRow = 0;
        int currentCol = cols - 1;
        // in the boarder
        while (currentRow < rows && currentCol > -1) {
            if (target == matrix[currentRow][currentCol]) return true;
            if (target > matrix[currentRow][currentCol]) {
                currentRow++;
            } else {
                currentCol--;
            }
        }
        return false;
    }
}

// Time Complexity: O(m+n）
// Space Complexity: O(1)
```

## 总结

1. 数组类题目上来先判断 `corner case`
2. 注意挖掘题目特征，认真审题

