public class spaceOptim {
    static int knapSack(int W, int wt[], int val[], int n) {

        int[] prev = new int[W + 1];

        for (int i = wt[0]; i <= W; i++) {
            prev[i] = val[0];
        }

        for (int ind = 1; ind < n; ind++) {
            int[] curr = new int[W + 1];
            for (int w = 0; w <= W; w++) {
                int notpick = prev[w];
                int pick = 0;
                if (wt[ind] <= w) {
                    pick = val[ind] + prev[w - wt[ind]];
                }
                curr[w] = Math.max(notpick, pick);
            }
            prev = curr;

        }
        return prev[W];
    }
}
// Time complexity : O(n*W)
// Space complexity : O(2*W)