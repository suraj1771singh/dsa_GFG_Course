import java.util.Arrays;

public class tabulation {
    static Boolean isSubsetSum(int N, int arr[], int sum) {

        return f(arr, N, sum);

    }

    static Boolean f(int[] a, int n, int k) {
        Boolean[][] dp = new Boolean[n][k + 1];
        for (Boolean[] row : dp)
            Arrays.fill(row, Boolean.FALSE);
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (a[0] <= k)
            dp[0][a[0]] = true;
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                if (ind == 0)
                    dp[ind][target] = (a[ind] == target);
                Boolean notpick = dp[ind - 1][target];
                Boolean pick = false;
                if (target >= a[ind])
                    pick = dp[ind - 1][target - a[ind]];
                dp[ind][target] = (pick || notpick);

            }
        }
        return dp[n - 1][k];
    }
}
