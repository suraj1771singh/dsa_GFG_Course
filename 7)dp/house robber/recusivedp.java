
class recusivedp {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = -1;
        }
        return solve(nums, nums.length - 1, dp);

    }

    public int solve(int[] nums, int index, int[] dp) {
        if (index == 0) {
            return dp[index] = nums[0];
        }
        if (index < 0) {
            return 0;
        }
        if (dp[index] != -1)
            return dp[index];

        int pick = nums[index] + solve(nums, index - 2, dp);
        int notpick = solve(nums, index - 1, dp);
        return dp[index] = Math.max(pick, notpick);
    }
}