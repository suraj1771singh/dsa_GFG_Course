import java.util.Arrays;

public class memoization {
    static int countWays(int n, String s) {
        int dp[][][] = new int[n][n][2];

        for (int[][] i : dp) {
            for (int[] j : i) {
                Arrays.fill(j, -1);
            }
        }
        return f(0, n - 1, true, s, dp);
    }

    static int f(int i, int j, boolean isTrue, String s, int[][][] dp) {
        if (i == j) {
            if (isTrue)
                return s.charAt(i) == 'T' ? 1 : 0;
            else
                return s.charAt(i) == 'F' ? 1 : 0;

        }

        if (isTrue) {
            if (dp[i][j][1] != -1)
                return dp[i][j][1];
        } else {
            if (dp[i][j][0] != -1)
                return dp[i][j][0];
        }

        int ways = 0;
        for (int k = i + 1; k <= j; k += 2) {
            // when left is true
            int lt = f(i, k - 1, true, s, dp);
            // when left is false
            int lf = f(i, k - 1, false, s, dp);
            // when right is true;
            int rt = f(k + 1, j, true, s, dp);
            // when right is false
            int rf = f(k + 1, j, false, s, dp);

            if (s.charAt(k) == '|') {
                // if OR

                if (isTrue)
                    ways += lt * rt + lt * rf + lf * rt;
                else
                    ways += lf * rf;
            } else if (s.charAt(k) == '&') {
                // if AND

                if (isTrue)
                    ways += lt * rt;
                else
                    ways += lf * rf + lt * rf + lf * rt;
            } else if (s.charAt(k) == '^') {
                // if XOR

                if (isTrue) {
                    ways += lt * rf + lf * rt;
                } else
                    ways += lt * rt + lf * rf;
            }
            ways %= 1003;
        }
        if (isTrue)
            return dp[i][j][1] = ways;

        return dp[i][j][0] = ways;
    }
}
// Time complexity : O(n^3)
// Space Complexity :O(n^2) +O(n)
