
// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(N, arr, sum))
                System.out.println(1);
            else
                System.out.println(0);

        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {

    static Boolean isSubsetSum(int N, int arr[], int sum) {
        return f(arr, N - 1, sum);

    }

    static Boolean f(int[] a, int ind, int target) {
        if (target == 0)
            return true;
        if (ind == 0) {
            return (a[0] == target);
        }
        Boolean notpick = f(a, ind - 1, target);
        Boolean pick = false;
        if (target >= a[ind])
            pick = f(a, ind - 1, target - a[ind]);
        return pick | notpick;
    }
}