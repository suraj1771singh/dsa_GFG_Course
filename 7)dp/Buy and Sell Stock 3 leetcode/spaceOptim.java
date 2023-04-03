public class spaceOptim {

    // SPACE OPTIMIZATION

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ahead[][] = new int[2][3];

        for (int i = n - 1; i >= 0; i--) {
            int curr[][] = new int[2][3];
            for (int buy = 0; buy < 2; buy++) {
                for (int k = 1; k < 3; k++) {
                    if (buy == 1) {
                        // either buy or skip
                        curr[buy][k] = Math.max(-prices[i] + ahead[0][k], ahead[1][k]);
                    } else {
                        // sell or skip
                        curr[buy][k] = Math.max(prices[i] + ahead[1][k - 1], ahead[0][k]);
                    }
                }
            }
            ahead = curr;
        }
        return ahead[1][2];
    }
}

// Time Complexity : O(N)
// Space Complexity  : O(1)
