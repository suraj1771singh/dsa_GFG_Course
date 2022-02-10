public class spaceOptim {
    // space optimsation

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        return getminpath(matrix, m, n);

    }

    public int getminpath(int[][] a, int m, int n) {
        int[] prev = new int[n];

        for (int j = 0; j < n; j++) {
            prev[j] = a[0][j];
        }
        for (int i = 1; i < m; i++) {
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {

                int first = a[i][j] + prev[j];
                int second = a[i][j];
                int third = a[i][j];
                if (j > 0)
                    second += prev[j - 1];
                else
                    second += (int) Math.pow(10, 4);
                if (j < n - 1)
                    third += prev[j + 1];
                else
                    third += (int) Math.pow(10, 4);
                curr[j] = Math.min(first, Math.min(second, third));
            }
            prev = curr;
        }
        int mini = prev[0];
        for (int j = 1; j < n; j++) {
            mini = Math.min(mini, prev[j]);
        }
        return mini;
    }
}

// Time complexity : O(m*n)
// Space complexity : O(m)
