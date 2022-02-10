// { Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends

// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();

        int di[] = { 1, 0, 0, -1 };
        int dj[] = { 0, -1, 1, 0 };
        if (m[0][0] == 1) {
            m[0][0] = 0;
            solve(ans, new StringBuilder(), di, dj, 0, 0, n, m);
        }
        return ans;
        // Your code here
    }

    public static void solve(ArrayList<String> ans, StringBuilder ds, int[] di, int[] dj, int row, int col, int n,
            int[][] m) {
        if (row == n - 1 && col == n - 1) {
            ans.add(ds.toString());
            return;
        }
        char[] position = { 'D', 'L', 'R', 'U' };
        for (int i = 0; i < di.length; i++) {
            int newrow = row + di[i];
            int newcol = col + dj[i];
            char a = position[i];
            if (isValid(newrow, newcol, n, m)) {
                m[newrow][newcol] = 0;
                ds.append(a);
                solve(ans, ds, di, dj, newrow, newcol, n, m);
                ds.deleteCharAt(ds.length() - 1);
                m[newrow][newcol] = 1;
            }

        }
    }

    public static boolean isValid(int row, int col, int n, int[][] m) {
        if (row >= 0 && row < n && col >= 0 && col < n && m[row][col] != 0)
            return true;
        return false;
    }
}

// Time Complexity : O(4^n^2)