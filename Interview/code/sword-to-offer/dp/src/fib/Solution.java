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
