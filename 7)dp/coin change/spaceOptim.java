public class spaceOptim {
    // space optimsiation
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
        int[] prev = new int[target + 1];
        int[] curr = new int[target + 1];
        for (int i = 0; i <= target; i++) {
            if (i % coins[0] == 0)
                prev[i] = i / coins[0];
            else
                prev[i] = (int) Math.pow(10, 9);
        }

        for (int ind = 1; ind < n; ind++) {

            for (int j = 0; j <= target; j++) {
                int notpick = prev[j];
                int pick = (int) Math.pow(10, 9);

                if (coins[ind] <= j) {
                    pick = 1 + curr[j - coins[ind]];
                }
                curr[j] = Math.min(notpick, pick);
            }
            prev = curr;
        }
        return prev[target];

    }
}
// Time Complexity : O(n*target)
// Space Complexity : O(target)
