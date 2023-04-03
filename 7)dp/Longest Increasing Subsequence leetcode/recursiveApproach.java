
//  RECURSIVE APPROACH
class Solution {
    public int lengthOfLIS(int[] nums) {
        return f(nums.length - 1, -1, nums);
    }

    public int f(int index, int prev_index, int[] nums) {
        if (index < 0)
            return 0;
        int notpick = f(index - 1, prev_index, nums);
        int pick = 0;
        if (prev_index == -1 || nums[index] < nums[prev_index])
            pick = 1 + f(index - 1, index, nums);
        return Math.max(notpick, pick);
    }
}