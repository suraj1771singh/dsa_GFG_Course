import java.util.Arrays;

//This problem is smiliar to bitonic subsequences 
//to get minium removal we have to find maximum length of possible bitcoinic 
//subsequence , and then subtract it from the length of given array

class Solution {
    public int minimumMountainRemovals(int[] nums) {
        return nums.length - LongestBitonicSequence(nums);

    }

    public int LongestBitonicSequence(int[] nums) {
        int n = nums.length, maxi = 0;
        int dp1[] = new int[n];
        Arrays.fill(dp1, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && 1 + dp1[j] > dp1[i])
                    dp1[i] = 1 + dp1[j];
            }
        }
        int dp2[] = new int[n];
        Arrays.fill(dp2, 1);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j] && 1 + dp2[j] > dp2[i])
                    dp2[i] = 1 + dp2[j];
            }
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