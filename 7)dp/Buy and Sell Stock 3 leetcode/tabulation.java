public class tabulation {

    // TABULATION

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n + 1][2][3];
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int k = 1; k < 3; k++) {
                    if (buy == 1) {
                        // either buy or skip
                        dp[i][buy][k] = Math.max(-prices[i] + dp[i + 1][0][k], dp[i + 1][1][k]);
                    } else {
                        // sell or skip
                        dp[i][buy][k] = Math.max(prices[i] + dp[i + 1][1][k - 1], dp[i + 1][0][k]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}
// Time Complexity : O(N)
// Space Complexity : O(N)