import java.util.Arrays;

public class memosiation {


    // memosiation

    static int knapSack(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n][W + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(n - 1, W, wt, val, dp);
    }

    static int f(int ind, int w, int[] wt, int[] val, int[][] dp) {
        if (ind == 0) {
            if (wt[0] <= w) {
                return val[0];
            } else
                return 0;
        }
        if (dp[ind][w] != -1)
            return dp[ind][w];
        int notpick = f(ind - 1, w, wt, val, dp);
        int pick = 0;
        if (wt[ind] <= w) {
            pick = val[ind] + f(ind - 1, w - wt[ind], wt, val, dp);
        }
        return dp[ind][w] = Math.max(notpick, pick);
    }
}
// Time complexity : O(n*W)
// Space complexity : O(n*W) +O{n}