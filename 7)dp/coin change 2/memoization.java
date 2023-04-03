import java.util.Arrays;

//memoization
public class memoization {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] x : dp)
            Arrays.fill(x, -1);
        return f(coins, n - 1, amount, dp);

    }

    public int f(int[] a, int ind, int target, int[][] dp) {

        if (ind == 0)
            return (target % a[0] == 0) ? 1 : 0;
        if (dp[ind][target] != -1)
            return dp[ind][target];
        int notpick = f(a, ind - 1, target, dp);
        int pick = 0;
        if (a[ind] <= target)
            pick = f(a, ind, target - a[ind], dp);

        return dp[ind][target] = notpick + pick;
    }
}
// Time Complexity : O(n*amount)
// Space Complexity :O(n*amount)+ >>O(n)  : because infinte each kind of coins available