//space optimisation

public class spaceOptim {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        return f(text1, text2, n, m);
    }

    public int f(String s1, String s2, int n, int m) {
        int[] prev = new int[m + 1];

        for (int j = 0; j <= m; j++)
            prev[j] = 0;

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    curr[j] = 1 + prev[j - 1];
                else
                    curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            prev = curr;
        }
        return prev[m];

    }
}

// Time Complexity : O(n*m)
// Space Complexity :O(m)
