//Efficient approach, making dp for palindrome check

public class effiSolution {
    public int minCut(String s) {
        int n = s.length();
        int dp[] = new int[n + 1];
        boolean pal[][] = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            pal[i][i] = true;
        }

        for (int i = n - 1; i >= 0; i--) {
            int mini = n - i;
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || pal[i + 1][j - 1])) {
                    pal[i][j] = true;
                    int count = 1 + dp[j + 1];
                    mini = Math.min(mini, count);
                }
            }
            dp[i] = mini;
        }
        return dp[0] - 1;

    }

}

// Time Complexity :O(n^2)
// Space Complexity :O(n)
