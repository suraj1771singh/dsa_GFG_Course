// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java

class Solution {
    // Function to swap odd and even bits.
    public static int swapBits(int n) {
        for (int i = 0; i < 32; i = i + 2) {
            int ith_bit = (n >> i) & 1;
            int i_1th_bit = (n >> (i + 1)) & 1;

            n = n
                    - (ith_bit << i)
                    - (i_1th_bit << (i + 1))
                    + (ith_bit << (i + 1))
                    + (i_1th_bit << i);

        }
        return n;
    }

}

// { Driver Code Starts.

class BitWise {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();// testcases
        while (t-- > 0) {
            int n = sc.nextInt();// taking n

            Solution obj = new Solution();

            // calling swapBits() method of class
            // Swap
            System.out.println(obj.swapBits(n));
        }
    }
} // } Driver Code Ends