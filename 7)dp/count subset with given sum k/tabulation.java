
// CORRECT : even working for array having zero's 

class tabulation {
    public int perfectSum(int arr[], int n, int sum) {
        return perfect(arr, n, sum);
    }

    int perfect(int[] a, int n, int sum) {
        int[][] dp = new int[n][sum + 1];
        int count = 0;
        // base case 1: handling zero's in an array
        for (int i = 0; i < n; i++) {
            if (a[i] == 0)
                count++;
            dp[i][0] = (int) Math.pow(2, count);
        }

        // base case 2:
        if (a[0] <= sum)
            dp[0][a[0]] = 1;

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= sum; target++) {
                int notpick = dp[ind - 1][target];
                int pick = 0;
                if (a[ind] <= target)
                    pick = dp[ind - 1][target - a[ind]];
                dp[ind][target] = (notpick + pick) % 1000000007;
            }
        }
        return dp[n - 1][sum];

    }

}
