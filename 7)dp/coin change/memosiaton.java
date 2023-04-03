import java.util.Arrays;

public class memosiaton {
    // memosiation
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = f(coins, n - 1, amount, dp);
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        else
            return ans;

    }

    public int f(int[] coins, int ind, int target, int[][] dp) {
        if (target == 0)
            return 0;
        if (ind == 0) {
            return (target % coins[0]) == 0 ? target / coins[0] : (int) Math.pow(10, 9);
        }
        if (dp[ind][target] != -1)
            return dp[ind][target];
        int notpick = f(coins, ind - 1, target, dp);

        int pick = (int) Math.pow(10, 9);

        if (coins[ind] <= target) {
            pick = 1 + f(coins, ind, target - coins[ind], dp);
        }
        return dp[ind][target] = Math.min(notpick, pick);

    }
}
// Time Complexity : O(n*target)
// Space Complexity : O(n*target) + o(n)