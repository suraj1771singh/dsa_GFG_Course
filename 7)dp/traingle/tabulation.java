import java.util.List;

public class tabulation {

    // tabulation

    public int minimumTotal(List<List<Integer>> triangle) {

        return getminpath(triangle);

    }

    public int getminpath(List<List<Integer>> tri) {
        int m = tri.size();
        int n = tri.get(m - 1).size();
        int[][] dp = new int[m][n];

        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = tri.get(n - 1).get(j);
        }

        int maxCol = n - 1;
        for (int i = m - 2; i >= 0; i--) {

            for (int j = 0; j < maxCol; j++) {
                int first = tri.get(i).get(j) + dp[i + 1][j];
                int second = tri.get(i).get(j) + dp[i + 1][j + 1];
                dp[i][j] = Math.min(first, second);

            }
            maxCol--;
        }
        return dp[0][0];

    }
}
// Time Complexity : O(n*m)
// space Complexity : O(n*m)
// n: the max length of col
// m : number of rows