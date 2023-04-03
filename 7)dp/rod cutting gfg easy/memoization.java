// { Driver Code Starts

import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            memoization ob = new memoization();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}
// } Driver Code Ends


//memoization
class memoization {
    public int cutRod(int price[], int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        return f(price, n, dp);
    }

    public int f(int a[], int target, int[] dp) {
        if (dp[target] != -1)
            return dp[target];
        int maxi = 0;
        for (int i = 0; i < target; i++) {
            int value = a[i] + f(a, target - (i + 1), dp);
            maxi = Math.max(maxi, value);
        }
        return dp[target] = maxi;
    }
}
// Time Complexity : O(n^2)
// Space Complexity :O(n)+O(n)