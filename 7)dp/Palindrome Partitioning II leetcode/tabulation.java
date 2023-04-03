
//tabulation

public class tabulation {

    public int minCut(String s) {
        int n = s.length();
        int dp[] = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int mini = 2000;
            for (int j = i; j < n; j++) {
                if (isPalindrome(i, j, s)) {
                    int count = 1 + dp[j + 1];
                    mini = Math.min(mini, count);
                }
            }
            dp[i] = mini;
        }
        return dp[0] - 1;

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
// Space Complexity :O(n)