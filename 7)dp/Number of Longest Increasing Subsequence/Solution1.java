import java.util.Arrays;

//  APPROACH
//  Its similar to LIS , so keep track of LIS using dp array
//  and traverse along it, to find largest number and it's frequency

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        int maxi = 0, ans = 0;
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[prev] < nums[i] && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    count[i] = count[prev];
                } else if (nums[prev] < nums[i] && 1 + dp[prev] == dp[i])
                    count[i] += count[prev];

            }
            // if (maxi == dp[i])
            // ans += count[i];
            // if (maxi < dp[i]) {
            // maxi = dp[i];
            // ans = count[i];
            // }

            maxi = Math.max(maxi, dp[i]);
        }
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxi) {
                ans += count[i];
            }
        }
        return ans;
    }
}

// Time Complexity :O(n^2)
// Space Complexity :O(n)