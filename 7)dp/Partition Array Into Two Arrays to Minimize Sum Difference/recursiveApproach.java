
//recursive approach

// for positive as well as negative numbers

// giving TLE

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int totalsum = 0;
        for (int i : nums)
            totalsum += i;
        return f(nums, n - 1, n / 2, totalsum, 0);

    }

    public int f(int[] a, int ind, int k, int totalsum, int sum) {
        if (ind == 0)
            if (k == 0)
                return Math.abs(2 * sum - totalsum);
            else
                return (int) Math.pow(10, 9);
        if (k == 0)
            return Math.abs(2 * sum - totalsum);
        // if (k < 0)
        // return (int) Math.pow(10, 9);

        int notpick = f(a, ind - 1, k, totalsum, sum);
        int pick = f(a, ind - 1, k - 1, totalsum, sum + a[ind]);

        return Math.min(notpick, pick);

    }
}