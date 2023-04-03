//tabulation

public class tabulation {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {

        return f(profit, weight, n, w);
    }

    public static int f(int[] val, int[] wt, int n, int w) {
        int[][] dp = new int[n][w + 1];
        // base case
        for (int i = 0; i <= w; i++) {
            if (wt[0] <= i)
                dp[0][i] = (i / wt[0]) * val[0];
        }
        for (int ind = 1; ind < n; ind++) {
            for (int j = 0; j <= w; j++) {
                int notpick = dp[ind - 1][j];
                int pick = -(int) Math.pow(10, 9);
                if (wt[ind] <= j)
                    pick = val[ind] + dp[ind][j - wt[ind]];
                dp[ind][j] = Math.max(notpick, pick);
            }
        }
        return dp[n - 1][w];

    }
}
