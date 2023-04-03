import java.util.Arrays;

// MEMOIZATION

public class memoization {
    public int maxSumAfterPartitioning(int[] arr, int k) {

        int dp[] = new int[arr.length + 1];
        Arrays.fill(dp, -1);

        return f(0, k, arr, dp);
    }

    public int f(int i, int k, int[] arr, int[] dp) {
        if (i == arr.length)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int len = 0;
        int maxiSum = 0;
        int maxiElemt = -1;
        for (int j = i; j < Math.min(k + i, arr.length); j++) {
            len++;
            maxiElemt = Math.max(maxiElemt, arr[j]);
            int sum = maxiElemt * (len) + f(j + 1, k, arr, dp);
            maxiSum = Math.max(maxiSum, sum);
        }
        return dp[i] = maxiSum;

    }

}

// Time Complexity O(n*k)
// Space Complexity O(n) +O(n)