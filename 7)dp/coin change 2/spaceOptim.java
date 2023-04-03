//space optmization
public class spaceOptim {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        return f(coins, n, amount);

    }

    public int f(int[] a, int n, int amount) {
        int[] prev = new int[amount + 1];
        int[] curr = new int[amount + 1];
        for (int i = 0; i <= amount; i++)
            if (i % a[0] == 0)
                prev[i] = 1;

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= amount; target++) {
                int notpick = prev[target];
                int pick = 0;
                if (a[ind] <= target)
                    pick = curr[target - a[ind]];

                curr[target] = notpick + pick;
            }
            prev = curr;
        }
        return prev[amount];

    }
}
// Time Complexity : O(n*amount)
// Space Complexity : O(amount)