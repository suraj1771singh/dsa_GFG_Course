
//     TABULATION

public class Approach2tab {
    static int countMin(String str) {
        int n = str.length();
        int dp[][] = new int[n][n];
        for (int k = n - 2; k >= 0; k--) {
            for (int i = k; i >= 0; i--) {
                int j = i + n - 1 - k;
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    

}
