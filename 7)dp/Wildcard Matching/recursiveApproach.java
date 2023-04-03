//------------RECURSIVE APPROACH

class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        return f(s, p, n - 1, m - 1);
    }

    public boolean f(String s1, String s2, int i, int j) {
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

        if (s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?')
            return f(s1, s2, i - 1, j - 1);
        if (s1.charAt(i) == '*')
            return f(s1, s2, i, j - 1) || f(s1, s2, i - 1, j);
        // if not equal to
        return false;
    }
}
// Time Complexity : exponential
// Space Complexity : O(n+m)