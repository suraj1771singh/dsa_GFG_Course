import java.util.Arrays;

//memosiation
class Solution {
    public int combinationSum4(int[] arr, int target) {
        int n = arr.length;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return countNumberOfCombinations(0, arr, target, dp);
    }

    public int countNumberOfCombinations(int index, int[] arr, int target, int[] dp) {
        if (target == 0) {
            return 1;
        }
        if (target < 0)
            return 0;

        if (dp[target] != -1)
            return dp[target];

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += countNumberOfCombinations(0, arr, target - arr[i], dp);
        }
        return dp[target] = sum;

    }
}