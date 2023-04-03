class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int i : nums) {
            totalSum += i;
        }
        return f(nums, nums.length - 1, 0, totalSum);
    }

    public boolean f(int[] nums, int index, int sum, int totalSum) {
        if (index < 0) {
            if (totalSum - sum == sum)
                return true;
            else
                return false;
        }
        boolean pick = f(nums, index - 1, sum + nums[index], totalSum);
        boolean notpick = f(nums, index - 1, sum, totalSum);
        return pick || notpick;
    }
}