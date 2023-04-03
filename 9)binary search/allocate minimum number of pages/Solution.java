// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.findPages(a, n, m));
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution {
    // Function to find minimum number of pages.
    public static int findPages(int[] w, int N, int d) {
        int maxi = -1, sum = 0;
        for (int i : w) {
            sum += i;
            maxi = Math.max(i, maxi);
        }
        // we know i.e we have to apply binary seach in range [maxi, sum]
        int l = maxi, r = sum;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (isFeasible(w, d, mid))
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }

    // checking wheather target is feasible or not
    // there should atmost d days req cannot be greater than d
    public static boolean isFeasible(int[] w, int d, int target) {
        int req = 1, sum = 0;
        for (int i : w) {
            if (i + sum > target) {
                req++;
                sum = i;
            } else {
                sum += i;
            }
        }
        return req <= d;
    }
};

// Time complexity : O(nlog(sum-maxi))