public class tabulation {

    // tabulation

    public int cherryPickup(int[][] grid) {

        return getmaxcherry(grid);

    }

    public int getmaxcherry(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];

        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = 0; j2 < n; j2++) {
                if (j1 == j2)
                    dp[m - 1][j1][j2] = grid[m - 1][j1];
                else
                    dp[m - 1][j1][j2] = grid[m - 1][j1] + grid[m - 1][j2];
            }
        }

        int[] mov = new int[] { -1, 0, 1 };

        for (int i = m - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < n; j1++) {
                for (int j2 = 0; j2 < n; j2++) {
                    int maxi = -(int) Math.pow(10, 4);
                    for (int u : mov) {
                        for (int v : mov) {
                            int value = 0;
                            if (j1 == j2)
                                value = grid[i][j1];
                            else
                                value = grid[i][j1] + grid[i][j2];
                            if (j1 + u >= 0 && j1 + u < n && j2 + v >= 0 && j2 + v < n)
                                value += dp[i + 1][j1 + u][j2 + v];
                            else
                                value += -Math.pow(10, 4);
                            maxi = Math.max(maxi, value);
                        }

                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][n - 1];
    }
}