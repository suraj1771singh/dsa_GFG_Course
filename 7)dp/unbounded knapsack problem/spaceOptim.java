// space optimization

public class spaceOptim {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {

        return f(profit, weight, n, w);
    }

    public static int f(int[] val, int[] wt, int n, int w) {
        int[] prev = new int[w + 1];
        int[] curr = new int[w + 1];
        // base case
        for (int i = 0; i <= w; i++) {
            if (wt[0] <= i)
                prev[i] = (i / wt[0]) * val[0];
        }
        for (int ind = 1; ind < n; ind++) {
            for (int j = 0; j <= w; j++) {
                int notpick = prev[j];
                int pick = -(int) Math.pow(10, 9);
                if (wt[ind] <= j)
                    pick = val[ind] + curr[j - wt[ind]];
                curr[j] = Math.max(notpick, pick);
            }
            prev = curr;
        }
        return prev[w];

    }
}
