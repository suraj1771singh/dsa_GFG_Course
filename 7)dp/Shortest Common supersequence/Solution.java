//------------------LCU approach
class Solution {
    public  String shortestCommonSupersequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        return f(text1, text2, n, m);
    }

    public  String f(String s1, String s2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = 0;
        for (int j = 0; j <= m; j++)
            dp[0][j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int i = n, j = m;
        int index = n + m - dp[n][m];
        char[] s = new char[index];
        index--;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                s[index] = s1.charAt(i - 1);
                i--;
                j--;
                index--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                s[index] = s1.charAt(i - 1);
                index--;
                i--;

            } else {
                s[index] = s2.charAt(j - 1);
                index--;
                j--;
            }
        }
        while (i > 0) {
            s[index] = s1.charAt(i - 1);
            index--;
            i--;
        }
        while (j > 0) {
            s[index] = s2.charAt(j - 1);
            index--;
            j--;
        }
        return String.valueOf(s);

    }
}  