//------------TABULATION DP SOLUTION
class Solution {
    public int maxSubArray(int[] nums) {
        int n= nums.length;
        if( n==1) return nums[0];
        int dp[]= new int [n];
        dp[0]=nums[0];
        int ans=dp[0];
        for(int i=1; i<n; i++){
            dp[i]=Math.max(nums[i], nums[i]+ dp[i-1]);
            ans=Math.max(ans, dp[i]);
        }
        return ans;
        
    }
}
//Time complexity : O(n)
//Space complexity : O(n)