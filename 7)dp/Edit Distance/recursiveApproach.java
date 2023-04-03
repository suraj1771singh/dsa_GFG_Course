//-------RECURSIVE APPROACH
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        return f(word1, word2, m - 1, n - 1);
    }

    public int f(String s1, String s2, int i, int j) {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;
        if (s1.charAt(i) == s2.charAt(j))
            return f(s1, s2, i - 1, j - 1);
        int insert = 1 + f(s1, s2, i, j - 1);
        int delete = 1 + f(s1, s2, i - 1, j);
        int replace = 1 + f(s1, s2, i - 1, j - 1);
        return Math.min(insert, Math.min(delete, replace));

    }
}
// Time complexity : exponential
// Space complexity : O(n+m)