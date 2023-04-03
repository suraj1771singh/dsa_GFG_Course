import java.util.Arrays;
// memoization

public class memoization {

    public int minCut(String s) {
        int dp[] = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        // subtraction at end because it is doing partitioning at after the end also
        return f(0, s.length(), s, dp) - 1;

    }

    public int f(int i, int n, String s, int[] dp) {
        if (i == n)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int mini = 2000;
        for (int j = i; j < n; j++) {
            if (isPalindrome(i, j, s)) {
                int count = 1 + f(j + 1, n, s, dp);
                mini = Math.min(mini, count);
            }
        }
        return dp[i] = mini;
    }

    public boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
// Time Complexity :O(n^3)
// Space Complexity :O(n)+O(n)