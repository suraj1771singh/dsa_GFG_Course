import java.util.Arrays;

public class Approach2Memo {
    static int countMin(String str) {
        int n = str.length();
        int dp[][] = new int[n][n];
        for (int[] x : dp)
            Arrays.fill(x, -1);
        return f(str, 0, n - 1, dp);
    }

    static int f(String str, int i, int j, int[][] dp) {
        if (i >= j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (str.charAt(i) == str.charAt(j)) {
            dp[i][j] = f(str, i + 1, j - 1, dp);
        } else {
            dp[i][j] = 1 + Math.min(f(str, i + 1, j, dp), f(str, i, j - 1, dp));
        }
        return dp[i][j];
    }
}
