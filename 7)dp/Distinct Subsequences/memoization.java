import java.util.Arrays;

//memoization
public class memoization {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m][n];
        for (int[] r : dp)
            Arrays.fill(r, -1);
        return f(s, t, m - 1, n - 1, dp);

    }

    public int f(String s1, String s2, int i, int j, int[][] dp) {
        if (j < 0)
            return 1;
        if (i < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = f(s1, s2, i - 1, j - 1, dp) + f(s1, s2, i - 1, j, dp);
        else
            return dp[i][j] = f(s1, s2, i - 1, j, dp);
    }
}
// Time complexity : o(n*m)
// Space Complexity : O(n*m) +O(n+m)