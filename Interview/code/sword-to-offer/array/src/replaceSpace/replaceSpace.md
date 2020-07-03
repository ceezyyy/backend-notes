# 05. 替换空格

## 题目

请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

 

**示例 1：**

输入：s = "We are happy."
输出："We%20are%20happy."



**限制：**

0 <= s 的长度 <= 10000



## 思路

遍历原字符串，新建一个 `StringBuffer` 可变字符串进行保存，最后将其转换为 `String`





## 题解

```java
class Solution {
    public String replaceSpace(String s) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            // meet space
            if (s.charAt(i) == ' ') {
                str.append("%20");
            } else {
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
}
```

