import java.util.Arrays;

public class memosiation {

    // memosiation

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int mini = (int) Math.pow(10, 4);
        int[][] dp = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        for (int j = 0; j < n; j++) {
            mini = Math.min(mini, getminpath(matrix, m - 1, j, n, dp));
        }
        return mini;

    }

    public int getminpath(int[][] a, int row, int col, int max_col, int[][] dp) {
        if (col < 0 || col >= max_col) {
            return (int) Math.pow(10, 4);
        }
        if (row == 0) {
            return a[0][col];

        }
        if (dp[row][col] != -1)
            return dp[row][col];

        int first = a[row][col] + getminpath(a, row - 1, col, max_col, dp);
        int second = a[row][col] + getminpath(a, row - 1, col - 1, max_col, dp);
        int third = a[row][col] + getminpath(a, row - 1, col + 1, max_col, dp);

        return dp[row][col] = Math.min(first, Math.min(second, third));
    }
}
// Time complexity : O(m*n)
// Space complexity : O(m*n) + O(m)