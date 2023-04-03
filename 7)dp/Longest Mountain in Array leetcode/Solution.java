import java.util.Arrays;

class Solution {
    public int longestMountain(int[] nums) {
        return LongestBitonicSequence(nums);

    }

    public int LongestBitonicSequence(int[] nums) {
        int n = nums.length, maxi = 0;
        int dp1[] = new int[n];
        Arrays.fill(dp1, 1);
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i])
                dp1[i] = 1 + dp1[i - 1];
        }
        int dp2[] = new int[n];
        Arrays.fill(dp2, 1);
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                dp2[i] = 1 + dp2[i + 1];
        }
        for (int i = 1; i < n - 1; i++) {
            // this condition to check
            // there should be atleast one smaller element to left
            // and atleast one smaller element to the right
            if (dp1[i] > 1 && dp2[i] > 1)
                maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
        }
        return maxi;
    }
}