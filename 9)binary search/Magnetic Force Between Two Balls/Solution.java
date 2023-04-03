import java.util.Arrays;
//--------------leetcode
//--------------BINARY SEARCH

class Solution {
    public int maxDistance(int[] position, int m) {
        int maxi = -1, ans = -1;
        for (int i : position)
            maxi = Math.max(maxi, i);
        Arrays.sort(position);
        int l = 1, h = maxi;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (canPlaceMagnet(position, m, mid)) {
                ans = mid;
                l = mid + 1;
            } else
                h = mid - 1;
        }
        return ans;

    }

    public boolean canPlaceMagnet(int[] a, int m, int dist) {
        int req = 1, lastPos = a[0];
        for (int i : a) {
            if (i - lastPos >= dist) {
                req++;
                lastPos = i;
            }
            if (req == m)
                return true;
        }
        return false;
    }
}