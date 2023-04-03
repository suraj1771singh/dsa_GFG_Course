public class tabulation {

    // tabulation
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int n = coins.length;

        int ans = f(coins, n, amount);
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        else
            return ans;

    }

    public int f(int[] coins, int n, int target) {
        int[][] dp = new int[n][target + 1];
        for (int i = 0; i <= target; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = i / coins[0];
            else
                dp[0][i] = (int) Math.pow(10, 9);
        }

        for (int ind = 1; ind < n; ind++) {
            for (int j = 0; j <= target; j++) {
                int notpick = dp[ind - 1][j];
                int pick = (int) Math.pow(10, 9);

                if (coins[ind] <= j) {
                    pick = 1 + dp[ind][j - coins[ind]];
                }
                dp[ind][j] = Math.min(notpick, pick);
            }
        }
        return dp[n - 1][target];

    }
}
// Time Complexity : O(n*target)
// Space Complexity : O(n*target)