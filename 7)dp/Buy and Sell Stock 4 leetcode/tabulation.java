public class tabulation {
    // TABULATION

    public int maxProfit(int K, int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n + 1][2][K + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int k = 1; k <= K; k++) {
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
        return dp[0][1][K];
    }
}
