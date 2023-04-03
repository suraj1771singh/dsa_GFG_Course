// TABULATION

class tabulation {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int len = 0;
            int maxiSum = 0;
            int maxiElemt = -1;
            for (int j = i; j < Math.min(k + i, arr.length); j++) {
                len++;
                maxiElemt = Math.max(maxiElemt, arr[j]);
                int sum = maxiElemt * (len) + dp[j + 1];
                maxiSum = Math.max(maxiSum, sum);
            }
            dp[i] = maxiSum;
        }
        return dp[0];
    }

}
// Time Complexity O(n*k)
// Space Complexity O(n)