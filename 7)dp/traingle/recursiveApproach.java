import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        return getminpath(triangle, 0, 0, triangle.size() - 1);

    }

    public int getminpath(List<List<Integer>> tri, int col, int row, int maxrow) {
        if (row == maxrow) {
            return tri.get(row).get(col);

        }
        int first = tri.get(row).get(col) + getminpath(tri, col, row + 1, maxrow);
        int second = tri.get(row).get(col) + getminpath(tri, col + 1, row + 1, maxrow);

        return Math.min(first, second);
    }
}
// Time Complexity : O(2^(n*m))
// space Complexity : O(m)
// n: the max length of col
// m : number of rows