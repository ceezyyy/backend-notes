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
