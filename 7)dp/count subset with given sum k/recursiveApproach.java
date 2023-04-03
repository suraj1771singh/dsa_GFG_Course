// { Driver Code Starts
//Initial Template for Java

import java.util.*;

class GfG {
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int sum = sc.nextInt();
                int arr[] = new int[n];
                for (int i = 0; i < n; i++)
                    arr[i] = sc.nextInt();

                Solution ob = new Solution();
                System.out.println(ob.perfectSum(arr, n, sum));
            }
        }
    }
} // } Driver Code Ends

// recursive approach

class Solution {

    public int perfectSum(int arr[], int n, int sum) {

        return perfect(arr, n - 1, sum);
    }

    int perfect(int[] a, int n, int sum) {
        if (n == 0) {
            if (sum == 0 && a[0] == 0)
                return 2;
            if (a[0] == sum || sum == 0)
                return 1;
            return 0;
        }

        int take = perfect(a, n - 1, sum);
        int don_take = 0;
        if (sum >= a[n])
            don_take = perfect(a, n - 1, sum - a[n]);

        return (take + don_take) % 1000000007;

    }
}
// Time complexity : O(2^n)
// Space complexity : O(n)