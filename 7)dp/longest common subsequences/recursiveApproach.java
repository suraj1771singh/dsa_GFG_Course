//recursive Approach

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        return f(text1, text2, text1.length() - 1, text2.length() - 1);
    }

    public int f(String s1, String s2, int i, int j) {
        if (i < 0 || j < 0)
            return 0;
        if (s1.charAt(i) == s2.charAt(j))
            return 1 + f(s1, s2, i - 1, j - 1);

        return Math.max(f(s1, s2, i - 1, j), f(s1, s2, i, j - 1));

    }
}

// Time Complexity : O(2^(n+m))
// Space Complexity :O(n+m)