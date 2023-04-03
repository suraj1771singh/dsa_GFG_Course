import java.util.Arrays;

//space optimised same as subset equal sum to k
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if ((sum & 1) != 0)// if odd
            return false;
        return f(nums, n, sum / 2);

    }

    public boolean f(int[] a, int n, int k) {
        boolean[] prev = new boolean[k + 1];
        Arrays.fill(prev, false);
        prev[0] = true;
        if (a[0] <= k)
            prev[a[0]] = true;
        for (int ind = 1; ind < n; ind++) {
            boolean[] curr = new boolean[k + 1];
            curr[0] = true;
            for (int target = 1; target <= k; target++) {
                boolean notpick = prev[target];
                boolean pick = false;
                if (target >= a[ind])
                    pick = prev[target - a[ind]];
                curr[target] = pick || notpick;
            }
            prev = curr;
        }
        return prev[k];

    }
}