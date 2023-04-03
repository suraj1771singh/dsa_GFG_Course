

//recursive Appraoch

public class recursiveAppraoch {

    public static int stockProfit(int[] prices) {
        return f(0, 1, prices);

    }

    public static int f(int index, int buy, int[] prices) {
        if (index >= prices.length)
            return 0;
        int profit = 0;
        if (buy == 1)
            // either buy or skip
            profit = Math.max(-prices[index] + f(index + 1, 0, prices), f(index + 1, 1, prices));
        else
            // either sel or skip
            profit = Math.max(prices[index] + f(index + 2, 1, prices), f(index + 1, 0, prices));

        return profit;

    }
}
