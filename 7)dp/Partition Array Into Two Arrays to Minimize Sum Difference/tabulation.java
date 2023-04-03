
//this is for non- negative numbers
//CORRECT solution : Codestudio

public class tabulation {

    public static int minSubsetSumDifference(int[] arr, int n) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        Boolean[][] dp = new Boolean[n][sum + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = false;
            }
        }
        targetSum(arr, n, dp, sum);// subset sum equal to target problem
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i <= sum / 2; i++) {
            if (dp[n - 1][i]) {
                int s1 = i;
                int s2 = sum - s1;
                mini = Math.min(mini, Math.abs(s1 - s2));
            }
        }
        return mini;

    }

    public static void targetSum(int[] a, int n, Boolean[][] dp, int sum) {

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][a[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                Boolean notpick = dp[i - 1][j];
                Boolean pick = false;
                if (a[i] <= j)
                    pick = dp[i - 1][j - a[i]];
                dp[i][j] = notpick || pick;
            }
        }
    }

}
