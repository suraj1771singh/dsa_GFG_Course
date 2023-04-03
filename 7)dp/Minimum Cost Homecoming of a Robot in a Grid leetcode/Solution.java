class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int ans = 0;
        int i = startPos[0];
        int j = startPos[1];
        int x = homePos[0];
        int y = homePos[1];

        // all path will cost same , because in all path we have to cross same number of
        // rows and cols
        while (i != x) {
            i += (x - i) / Math.abs(x - i);
            ans += rowCosts[i];
        }
        while (j != y) {
            j += (y - j) / Math.abs(y - j);
            ans += colCosts[j];
        }
        return ans;

    }
}