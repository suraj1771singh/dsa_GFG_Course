
//recursive solution
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int mini = (int) Math.pow(10, 4);
        for (int j = 0; j < n; j++) {
            mini = Math.min(mini, getminpath(matrix, m - 1, j, n));
        }
        return mini;

    }

    public int getminpath(int[][] a, int row, int col, int max_col) {
        if (col < 0 || col >= max_col) {
            return (int) Math.pow(10, 4);
        }
        if (row == 0) {
            return a[0][col];

        }

        int first = a[row][col] + getminpath(a, row - 1, col, max_col);
        int second = a[row][col] + getminpath(a, row - 1, col - 1, max_col);
        int third = a[row][col] + getminpath(a, row - 1, col + 1, max_col);

        return Math.min(first, Math.min(second, third));
    }
}
// Time complexity : O(3^m)
// Space complexity : O(m)