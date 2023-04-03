// tabulation
public class tabulation {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        return f(coins, n, amount);

    }

    public int f(int[] a, int n, int amount) {
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i <= amount; i++)
            if (i % a[0] == 0)
                dp[0][i] = 1;

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= amount; target++) {
                int notpick = dp[ind - 1][target];
                int pick = 0;
                if (a[ind] <= target)
                    pick = dp[ind][target - a[ind]];

                dp[ind][target] = notpick + pick;
            }
        }
        return dp[n - 1][amount];

    }
}
// Time Complexity : O(n*amount)
// Space Complexity : O(n*amount)