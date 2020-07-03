package findNumberIn2DArray;

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
