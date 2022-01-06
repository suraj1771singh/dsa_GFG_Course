
import java.io.*;
import java.util.*;

class Solution {
    // ---------------------------Time complexity -:
    // Theta(n)--------------------------
    //
    // public static int maxConsecutiveOnes(int n)
    // {
    // int max=0,count=0;
    // while(n>0){
    // if((n&1)!=0){
    // count++;
    // if(count>max) max=count;
    // }else{count=0;}

    // n=n>>1;
    // }
    // return max;
    // }
    // -----------------------------Time complexity -: Theta(log n)----

    public static int maxConsecutiveOnes(int n) {

        int count = 0;
        while (n > 0) {
            count++;
            n = n & (n << 1);
        }
        return count;

    }
}

// { Driver Code Starts.

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();// testcases
        while (t-- > 0) {
            int n = sc.nextInt();// input n

            Solution obj = new Solution();

            // calling maxConsecutiveOnes() function
            System.out.println(obj.maxConsecutiveOnes(n));
        }
    }
}

// } Driver Code Ends