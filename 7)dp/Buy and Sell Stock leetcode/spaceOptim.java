
public class spaceOptim {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int prev = 0, curr;
        int mini = prices[0];
        for (int i = 1; i < n; i++) {
            mini = Math.min(mini, prices[i]);
            curr = Math.max(prev, prices[i] - mini);
            prev = curr;

        }
        return prev;
    }
}

// Time Complexity :O(n)
// Space Complexity :O(1)