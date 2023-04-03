import java.util.Arrays;

//memoization

class memoization {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int new_nums[] = new int[n + 2];
        new_nums[0] = 1;
        for (int ind = 0; ind < n; ind++) {
            new_nums[ind + 1] = nums[ind];
        }
        new_nums[n + 1] = 1;
        int i = 1, j = n;
        
        int dp[][] = new int[n + 1][n + 1];
        for (int x[] : dp)
            Arrays.fill(x, -1);
        return f(new_nums, i, j, dp);
    }

    public int f(int a[], int i, int j, int[][] dp) {
        if (i > j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int maxi = 0;
        for (int ind = i; ind <= j; ind++) {
            int cost = a[i - 1] * a[ind] * a[j + 1] + f(a, i, ind - 1, dp) + f(a, ind + 1, j, dp);
            maxi = Math.max(maxi, cost);
        }
        return dp[i][j] = maxi;

    }
}