//--------------TABULATION
public class tabulation {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        return f(p, s, m, n);
    }

    public boolean f(String s1, String s2, int m, int n) {
        boolean[][] dp = new boolean[m + 1][n + 1];
        // base case 1
        dp[0][0] = true;
        // base case 2
        for (int j = 1; j <= n; j++)
            dp[0][j] = false;
        // base case 3
        int pos = 1;
        while (true) {
            if (pos > m || s1.charAt(pos - 1) != '*')
                break;
            dp[pos][0] = true;
            pos++;
        }
        for (int k = pos; k <= m; k++)
            dp[k][0] = false;
        // --------------------------------

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1) || s1.charAt(i - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (s1.charAt(i - 1) == '*')
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                else
                    dp[i][j] = false;

            }
        }
        return dp[m][n];
    }
}
// Time Complexity : O(n*m)
// Space Complexity : O(n*m)