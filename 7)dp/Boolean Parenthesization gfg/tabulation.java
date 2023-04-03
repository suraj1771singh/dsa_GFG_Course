public class tabulation {
    static int countWays(int n, String s) {
        int dp[][][] = new int[n][n][2];

        for (int i = 0; i < n; i += 2) {
            if (s.charAt(i) == 'T')
                dp[i][i][1] = 1;
            else if (s.charAt(i) == 'F')
                dp[i][i][0] = 1;
        }
        for (int i = n - 1; i >= 0; i -= 2) {
            for (int j = i + 2; j < n; j += 2) {
                for (int isTrue = 1; isTrue >= 0; isTrue--) {
                    int ways = 0;
                    for (int k = i + 1; k <= j; k += 2) {
                        // when left is true
                        int lt = dp[i][k - 1][1];
                        // when left is false
                        int lf = dp[i][k - 1][0];
                        // when right is true;
                        int rt = dp[k + 1][j][1];
                        // when right is false
                        int rf = dp[k + 1][j][0];

                        if (s.charAt(k) == '|') {
                            // if OR

                            if (isTrue == 1)
                                ways += lt * rt + lt * rf + lf * rt;
                            else
                                ways += lf * rf;
                        } else if (s.charAt(k) == '&') {
                            // if AND

                            if (isTrue == 1)
                                ways += lt * rt;
                            else
                                ways += lf * rf + lt * rf + lf * rt;
                        } else if (s.charAt(k) == '^') {
                            // if XOR

                            if (isTrue == 1) {
                                ways += lt * rf + lf * rt;
                            } else
                                ways += lt * rt + lf * rf;
                        }
                        ways %= 1003;
                        dp[i][j][isTrue] = ways;
                    }
                }
            }
        }
        return dp[0][n - 1][1];
    }
}

// Time complexity : O(n^3)
// Space Complexity :O(n^2)
