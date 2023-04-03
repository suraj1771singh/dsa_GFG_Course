import java.util.Arrays;

public class tabulation {
    // tabulation

    static int knapSack(int W, int wt[], int val[], int n) {

        int[][] dp = new int[n][W + 1];
        for (int i = wt[0]; i <= W; i++) {
            dp[0][i] = val[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int w = 0; w <= W; w++) {
                int notpick = dp[ind - 1][w];
                int pick = 0;
                if (wt[ind] <= w) {
                    pick = val[ind] + dp[ind - 1][w - wt[ind]];
                }
                dp[ind][w] = Math.max(notpick, pick);
            }

        }
        return dp[n - 1][W];
    }

}
// Time complexity : O(n*W)
// Space complexity : O(n*W)