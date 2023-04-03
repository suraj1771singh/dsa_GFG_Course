
// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < n; j++) {
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends

class Solution {

    public boolean is_Possible(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (DFSRec(i, j, grid))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean DFSRec(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return false;
        if (grid[i][j] == 2)
            return true;
        if (grid[i][j] == 0)
            return false;
        if (grid[i][j] == 3)
            grid[i][j] = 0;
        if (DFSRec(i + 1, j, grid))
            return true;
        if (DFSRec(i - 1, j, grid))
            return true;
        if (DFSRec(i, j + 1, grid))
            return true;
        if (DFSRec(i, j - 1, grid))
            return true;
        grid[i][j] = 3;
        return false;

    }
}

// Time Complexity :O(4^(N*N))
// using DFS