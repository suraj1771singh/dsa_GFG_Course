import java.util.Arrays;

public class spaceOptim {
    public int uniquePathsWithObstacles(int[][] a) {

        int m = a.length;
        int n = a[0].length;
        int[] prev = new int[n];
        Arrays.fill(prev, 0);
        for (int i = 0; i < m; i++) {
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1)
                    curr[j] = 0;
                else if (i == 0 && j == 0)
                    curr[j] = 1;
                else {
                    int up = 0;
                    int left = 0;
                    if (i > 0)
                        up = prev[j];
                    if (j > 0)
                        left = curr[j - 1];

                    curr[j] = up + left;
                }

            }
            prev = curr;
        }
        return prev[n - 1];

    }
}

// Time complexity : O(n*m);
// space complexity : O(n) : n is the number of cols
