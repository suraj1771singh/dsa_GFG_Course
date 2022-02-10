public class tabulation {

    // tabulation

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        return getminpath(matrix, m, n);

    }

    public int getminpath(int[][] a, int m, int n) {
        int[][] dp = new int[m][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = a[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int first = a[i][j] + dp[i - 1][j];
                int second = a[i][j];
                int third = a[i][j];
                if (j > 0)
                    second += dp[i - 1][j - 1];
                else
                    second += (int) Math.pow(10, 4);
                if (j < n - 1)
                    third += dp[i - 1][j + 1];
                else
                    third += (int) Math.pow(10, 4);
                dp[i][j] = Math.min(first, Math.min(second, third));
            }
        }
        int mini = dp[m - 1][0];
        for (int j = 1; j < n; j++) {
            mini = Math.min(mini, dp[m - 1][j]);
        }
        return mini;
    }
}
// Time complexity : O(m*n)
// Space complexity : O(m*n)