//  tabulation 
// similar to count subset with given sum
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0, n = nums.length;
        for (int i : nums)
            sum += i;

        // target should not be greater than sum
        // checking that new target should be integer
        if (sum < Math.abs(target) || (target + sum) % 2 != 0)
            return 0;

        int newtarget = (target + sum) / 2;
        return countSubsets(nums, n, newtarget);
    }

    public int countSubsets(int[] a, int n, int sum) {
        int[][] dp = new int[n][sum + 1];
        int count = 0;
        // base case 1:
        if (a[0] <= sum)
            dp[0][a[0]] = 1;

        // base case 2: handling zero's in an array
        for (int i = 0; i < n; i++) {
            if (a[i] == 0)
                count++;
            dp[i][0] = (int) Math.pow(2, count);
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= sum; target++) {
                int notpick = dp[ind - 1][target];
                int pick = 0;
                if (a[ind] <= target)
                    pick = dp[ind - 1][target - a[ind]];
                dp[ind][target] = (notpick + pick) % 1000000007;
            }
        }
        return dp[n - 1][sum];

    }

}