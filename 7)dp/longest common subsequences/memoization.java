import java.util.Arrays;

//memoization
public class memoization {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for (int[] c : dp)
            Arrays.fill(c, -1);
        return f(text1, text2, n - 1, m - 1, dp);
    }

    public int f(String s1, String s2, int i, int j, int[][] dp) {
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 1 + f(s1, s2, i - 1, j - 1, dp);

        return dp[i][j] = Math.max(f(s1, s2, i - 1, j, dp), f(s1, s2, i, j - 1, dp));

    }
}

// Time Complexity : O(n*m)
// Space Complexity :O(n*m) +O(n+m)