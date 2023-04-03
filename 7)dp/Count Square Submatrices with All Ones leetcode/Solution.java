class Solution {
    public int countSquares(int[][] a) {
        int res = 0;
        int m = a.length;
        int n = a[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {
                    if (i == 0 || j == 0)
                        res++;
                    else {
                        a[i][j] += Math.min(a[i - 1][j - 1], Math.min(a[i - 1][j], a[i][j - 1]));
                        res += a[i][j];
                    }
                }
            }
        }
        return res;
    }
}
// Time Complexity : O(n*m)
// Space Complexity :O(n*m)