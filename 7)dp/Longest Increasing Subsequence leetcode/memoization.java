import java.util.Arrays;

// MEMOIZATION

public class memoization {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return f(n - 1, -1, nums, dp);
    }

    public int f(int index, int prev_index, int[] nums, int[][] dp) {
        if (index < 0)
            return 0;
        if (dp[index][prev_index + 1] != -1)
            return dp[index][prev_index + 1];
        int notpick = f(index - 1, prev_index, nums, dp);
        int pick = 0;
        if (prev_index == -1 || nums[index] < nums[prev_index])
            pick = 1 + f(index - 1, index, nums, dp);

        return dp[index][prev_index + 1] = Math.max(notpick, pick);

    }

}
