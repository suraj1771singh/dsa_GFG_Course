
//Article
// https://medium.com/algorithms-digest/bursting-balloons-1820664a4ffa

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int new_nums[] = new int[n + 2];
        new_nums[0] = 1;
        for (int ind = 0; ind < n; ind++) {
            new_nums[ind + 1] = nums[ind];
        }
        new_nums[n + 1] = 1;
        int i = 1, j = n;
        return f(new_nums, i, j);

    }

    public int f(int[] a, int i, int j) {
        if (i > j)
            return 0;
        int maxi = 0;
        for (int k = i; k <= j; k++) {
            int cost = a[i - 1] * a[k] * a[j + 1] + f(a, i, k - 1) + f(a, k + 1, j);
            maxi = Math.max(maxi, cost);

        }
        return maxi;
    }
}