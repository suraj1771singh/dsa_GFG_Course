// recursive solution
class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid[0].length;
        return getmaxcherry(grid, 0, 0, n - 1);

    }

    public int getmaxcherry(int[][] grid, int i, int j1, int j2) {
        int m = grid.length;
        int n = grid[0].length;

        if (j1 < 0 || j1 >= n || j2 < 0 || j2 >= n) {
            return -(int) Math.pow(10, 4);
        }

        if (i == m - 1) {
            if (j1 == j2)
                return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }

        int[] mov = new int[] { -1, 0, 1 };
        int maxi = -(int) Math.pow(10, 4);
        for (int u : mov) {
            for (int v : mov) {
                if (j1 == j2) {
                    maxi = Math.max(maxi, grid[i][j1] + getmaxcherry(grid, i + 1, j1 + u, j2 + v));
                } else {
                    maxi = Math.max(maxi, grid[i][j1] + grid[i][j2] + getmaxcherry(grid, i + 1, j1 + u, j2 + v));
                }
            }
        }
        return maxi;
    }
}