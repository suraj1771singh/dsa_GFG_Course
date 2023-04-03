
// memoization
public class memoization {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = -1;
            }
        }
        return f(profit, weight, n - 1, w, dp);
    }

    public static int f(int[] val, int[] wt, int ind, int w, int[][] dp) {
        if (ind == 0) {
            if (wt[0] <= w)
                return (w / wt[0]) * val[0];
            return 0;
        }
        if (dp[ind][w] != -1)
            return dp[ind][w];
        int notpick = f(val, wt, ind - 1, w, dp);
        int pick = -(int) Math.pow(10, 9);
        if (wt[ind] <= w)
            pick = val[ind] + f(val, wt, ind, w - wt[ind], dp);

        return dp[ind][w] = Math.max(notpick, pick);
    }
}
