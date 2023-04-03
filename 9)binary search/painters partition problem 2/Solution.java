// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.minTime(arr, n, k));
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    static long minTime(int[] arr, int n, int k) {
        long maxi = -1, sum = 0, ans = -1;
        for (int i : arr) {
            sum += i;
            maxi = Math.max(maxi, i);
        }
        long l = maxi, h = sum;
        while (l <= h) {
            long mid = l + (h - l) / 2;
            if (isFeasible(arr, k, mid)) {
                ans = mid;
                h = mid - 1;
            } else
                l = mid + 1;
        }
        return ans;
    }

    static boolean isFeasible(int[] arr, int k, long target) {
        int req = 1;
        long sum = 0;
        for (int i : arr) {
            if (sum + i > target) {
                req++;
                sum = i;
            } else
                sum += i;
        }
        return req <= k;
    }
}

// Time Complexity : O(n *log(sum-maxi))