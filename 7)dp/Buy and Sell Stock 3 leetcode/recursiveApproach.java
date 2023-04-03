class recursiveApproach {
    public int maxProfit(int[] prices) {
        return f(0, 1, 2, prices);

    }

    public int f(int ind, int buy, int k, int[] prices) {
        if (ind == prices.length)
            return 0;
        if (k == 0)
            return 0;
        int profit = 0;
        if (buy == 1) {
            // either buy or skip
            profit = Math.max(-prices[ind] + f(ind + 1, 0, k, prices), f(ind + 1, 1, k, prices));
        } else {
            // sell or skip
            profit = Math.max(prices[ind] + f(ind + 1, 1, k - 1, prices), f(ind + 1, 0, k, prices));
        }
        return profit;

    }
}
// Time Complexity : O(2^N) exponential
// Space Complexity : O(N) (auxiallry space)