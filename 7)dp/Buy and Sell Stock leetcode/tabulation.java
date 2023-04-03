
// tabulation

public class tabulation {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[] = new int[n];
        int mini = prices[0];
        for (int i = 1; i < n; i++) {
            mini = Math.min(mini, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - mini);

        }
        return dp[n - 1];
    }
}

// Time complexity : O(n)
// Space Complexity :O(n)