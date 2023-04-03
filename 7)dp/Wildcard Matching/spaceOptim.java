public class spaceOptim {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        return f(p, s, m, n);
    }

    public boolean f(String s1, String s2, int m, int n) {
        boolean[] prev = new boolean[n + 1];
        int flag = 1;
        // base case 1
        prev[0] = true;
        // base case 2
        for (int j = 1; j <= n; j++)
            prev[j] = false;
        // --------------------------------

        for (int i = 1; i <= m; i++) {
            boolean[] curr = new boolean[n + 1];
            if (flag == 1 && s1.charAt(i - 1) == '*')
                curr[0] = true;
            else {
                curr[0] = false;
                flag = 0;
            }
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1) || s1.charAt(i - 1) == '?')
                    curr[j] = prev[j - 1];
                else if (s1.charAt(i - 1) == '*')
                    curr[j] = curr[j - 1] || prev[j];
                else
                    curr[j] = false;
            }
            prev = curr;
        }
        return prev[n];
    }
}

// Time Complexity : O(n*m)
// Space Complexity : O(n)
