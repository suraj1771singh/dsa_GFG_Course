//--------Recursive solution
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        return f(s, t, m - 1, n - 1);

    }

    public int f(String s1, String s2, int i, int j) {
        if (j < 0)
            return 1;
        if (i < 0)
            return 0;
        if (s1.charAt(i) == s2.charAt(j))
            return f(s1, s2, i - 1, j - 1) + f(s1, s2, i - 1, j);
        else
            return f(s1, s2, i - 1, j);
    }
}
// Time complexity:exponential
// Space complexity : O(n+m)