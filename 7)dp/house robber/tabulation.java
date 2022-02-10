//tabulation 

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = -1;
        }
        dp[0] = nums[0];

        return solve(nums, nums.length - 1, dp);

    }

    public int solve(int[] nums, int index, int[] dp) {
        for (int i = 1; i < nums.length; i++) {
            int pick = nums[i];
            if (i > 1)
                pick += dp[i - 2];
            int notpick = dp[i - 1];

            dp[i] = Math.max(pick, notpick);
        }
        return dp[nums.length - 1];

    }
}