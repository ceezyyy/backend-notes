# 56 - II. 数组中数字出现的次数 II

## 题目

在一个数组 `nums` 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。

**示例 1：**

输入：nums = [3,4,3,3]
输出：4

**示例 2：**

输入：nums = [9,1,7,9,7,9,7]
输出：1


限制：

1 <= nums.length <= 10000
1 <= nums[i] < 2^31



## 思路

### 常规思路

将数组排序，遍历判断，再考虑首尾元素的 `corner case`







## 题解

### 常规解法

```java
package singleNumber;

import java.util.Arrays;


// Solution One
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // first element
        if (nums[0] != nums[1]) return nums[0];
        // last element
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];
        for (int i = 1; i < n - 1; i++) {
            if ((nums[i] != nums[i - 1]) && (nums[i] != nums[i + 1])) {
                return nums[i];
            }
        }
        return -1;
    }
}


// Time Complexity: O(nlogn)
// Space Complexity: O(1)
```

