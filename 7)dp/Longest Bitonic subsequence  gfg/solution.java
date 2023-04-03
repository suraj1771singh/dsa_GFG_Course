import java.util.Arrays;

//         GFG

// This problem is similar to LIS 
// step 1 calculate LIS table for array 
// step 2 calculate LIS tabel for same array but from right to left 
//        (just like moutain, it increased from left to right and increase from right to left as well)
// now  for every element do arr1[i]+arr2[i] -1 and find max

class Solution {
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
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
        }
        return maxi;
    }
}