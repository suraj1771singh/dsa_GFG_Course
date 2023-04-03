import java.util.Arrays;

//-------MEMOIZATION
public class memoization {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        for (int[] r : dp)
            Arrays.fill(r, -1);
        return f(word1, word2, m - 1, n - 1, dp);
    }

    public int f(String s1, String s2, int i, int j, int[][] dp) {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = f(s1, s2, i - 1, j - 1, dp);
        int insert = 1 + f(s1, s2, i, j - 1, dp);
        int delete = 1 + f(s1, s2, i - 1, j, dp);
        int replace = 1 + f(s1, s2, i - 1, j - 1, dp);
        return dp[i][j] = Math.min(insert, Math.min(delete, replace));

    }
}
// Time complexity : O(n*m)
// Space complexity : O(n*m) +O(n+m)