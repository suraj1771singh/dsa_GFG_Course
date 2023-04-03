//recursive approach
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        return f(coins, n - 1, amount);

    }

    public int f(int[] a, int ind, int target) {

        if (ind == 0)
            return (target % a[0] == 0) ? 1 : 0;

        int notpick = f(a, ind - 1, target);
        int pick = 0;
        if (a[ind] <= target)
            pick = f(a, ind, target - a[ind]);

        return notpick + pick;
    }
}

// Time Complexity : >>O(2^n) : because infinte each kind of coins available
// Space Complexity : >>O(n) : because infinte each kind of coins available