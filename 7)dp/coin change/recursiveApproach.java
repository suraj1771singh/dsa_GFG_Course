class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int n = coins.length;
        int ans = f(coins, n - 1, amount);
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        else
            return ans;

    }

    public int f(int[] coins, int ind, int target) {
        if (target == 0)
            return 0;
        if (ind == 0) {
            return (target % coins[0]) == 0 ? target / coins[0] : (int) Math.pow(10, 9);
        }
        int notpick = f(coins, ind - 1, target);
        int pick = (int) Math.pow(10, 9);
        if (coins[ind] <= target) {
            pick = 1 + f(coins, ind, target - coins[ind]);
        }
        return Math.min(notpick, pick);

    }
}
// Time Complexity : >>O(2^n) : because we are picking one index and again
// staying at same index
// Space Complexity : >>O(n)