import java.util.Arrays;

//memosiation

public class memosiation {

    static Boolean isSubsetSum(int N, int arr[], int sum) {
        int[][] dp = new int[N][sum + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return f(arr, N - 1, sum, dp);

    }

    static Boolean f(int[] a, int ind, int target, int[][] dp) {
        if (target == 0)
            return true;
        if (ind == 0) {
            return (a[0] == target);
        }
        if (dp[ind][target] != -1)
            return (dp[ind][target] == 0) ? false : true;
        Boolean notpick = f(a, ind - 1, target, dp);
        Boolean pick = false;
        if (target >= a[ind])
            pick = f(a, ind - 1, target - a[ind], dp);
        dp[ind][target] = (pick || notpick) ? 1 : 0;
        return pick || notpick;
    }
}