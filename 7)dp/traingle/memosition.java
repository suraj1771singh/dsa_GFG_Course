import java.util.Arrays;
import java.util.List;

//memosition

class memosition {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getminpath(triangle, 0, 0, triangle.size() - 1, dp);

    }

    public int getminpath(List<List<Integer>> tri, int col, int row, int maxrow, int[][] dp) {
        if (row == maxrow) {
            return tri.get(row).get(col);

        }
        if (dp[row][col] != -1)
            return dp[row][col];
        int first = tri.get(row).get(col) + getminpath(tri, col, row + 1, maxrow, dp);
        int second = tri.get(row).get(col) + getminpath(tri, col + 1, row + 1, maxrow, dp);

        return dp[row][col] = Math.min(first, second);
    }
}
// Time Complexity : O(n*m)
// space Complexity : O(n*m) + O(m)
// n: the max length of col
// m : number of rows