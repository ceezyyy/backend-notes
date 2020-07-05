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
