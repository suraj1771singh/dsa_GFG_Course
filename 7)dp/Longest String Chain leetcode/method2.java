import java.util.Arrays;
import java.util.Comparator;

//-----METHODE (LIS METHOD)

class MyComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
}

class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        int maxi = 0;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(words, new MyComparator());
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (isPossible(i, prev, words) && 1 + dp[prev] > dp[i])
                    dp[i] = 1 + dp[prev];
            }
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;

    }

    private boolean isPossible(int ind, int prev, String[] words) {
        String s1 = words[ind];
        String s2 = words[prev];
        if (s1.length() != 1 + s2.length())
            return false;
        int i = 0, j = 0;
        boolean flag = false;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
                flag = true;
            }
        }
        if (!flag)
            return true;
        if (s1.length() == i && s2.length() == j)
            return true;
        return false;
    }

}