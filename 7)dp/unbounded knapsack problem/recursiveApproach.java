
//recursive approach
class Solution {
    int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        return f(profit, weight, n - 1, w);
    }

    int f(int[] val, int[] wt, int ind, int w) {
        if (ind == 0) {
            if (wt[0] <= w)
                return (w / wt[0]) * val[0];
            return 0;
        }
        int notpick = f(val, wt, ind - 1, w);
        int pick = -(int) Math.pow(10, 9);
        if (wt[ind] <= w)
            pick = val[ind] + f(val, wt, ind, w - wt[ind]);

        return Math.max(notpick, pick);
    }
}
