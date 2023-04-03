
//tabulation
public class tabulation {

    public int cutRod(int price[], int n) {
        return f(price, n);
    }

    public int f(int a[], int target) {
        int[] dp = new int[target + 1];
        for (int t = 0; t <= target; t++) {
            int maxi = 0;
            for (int i = 0; i < t; i++) {
                int value = a[i] + dp[t - (i + 1)];
                maxi = Math.max(maxi, value);
            }
            dp[t] = maxi;
        }

        return dp[target];
    }
}

// Time Complexity : O(n^2)
// Space Complexity :O(n)

// space optimization is not possible because at every we need whole dp arrray