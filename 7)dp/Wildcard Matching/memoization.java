import java.util.Arrays;

//------------MEMOIZATION
public class memoization {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[m][n];
        for (int[] r : dp)
            Arrays.fill(r, -1);
        return f(p, s, m - 1, n - 1, dp);
    }

    public boolean f(String s1, String s2, int i, int j, int[][] dp) {
        // base cases
        // case 1
        if (i < 0 && j < 0)
            return true;
        // case 2
        if (i < 0 && j >= 0)
            return false;
        // case 3
        if (j < 0 && i >= 0) {
            for (int k = 0; k <= i; k++)
                if (s1.charAt(k) != '*')
                    return false;
            return true;
        }
        if (dp[i][j] != -1)
            return dp[i][j] == 1 ? true : false;

        if (s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?') {
            boolean ans = f(s1, s2, i - 1, j - 1, dp);
            dp[i][j] = ans ? 1 : 0;
            return ans;

        }
        if (s1.charAt(i) == '*') {
            boolean ans = f(s1, s2, i, j - 1, dp) || f(s1, s2, i - 1, j, dp);
            dp[i][j] = ans ? 1 : 0;
            return ans;
        }
        // if not equal to
        dp[i][j] = 0;
        return false;
    }
}
// Time Complexity : O(n*m)
// Space Complexity : O(n+m) + O(n*m)