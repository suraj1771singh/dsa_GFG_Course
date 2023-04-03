import java.util.Arrays;

//   MEMOIZATION
public class memoization {
    public static int stockProfit(int[] prices) {
        int dp[][] = new int[prices.length + 1][2];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return f(0, 1, prices, dp);

    }

    public static int f(int index, int buy, int[] prices, int[][] dp) {
        if (index >= prices.length)
            return 0;
        if (dp[index][buy] != -1)
            return dp[index][buy];
        int profit = 0;
        if (buy == 1)
            // either buy or skip
            profit = Math.max(-prices[index] + f(index + 1, 0, prices, dp), f(index + 1, 1, prices, dp));
        else
            // either sel or skip
            profit = Math.max(prices[index] + f(index + 2, 1, prices, dp), f(index + 1, 0, prices, dp));

        return dp[index][buy] = profit;

    }
}
