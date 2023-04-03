class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if (dist.length - 1 > hour)
            return -1;
        int ans = -1;
        int l = 1, h = 10000000;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (isPossible(dist, hour, mid)) {
                h = mid - 1;
                ans = mid;
            } else
                l = mid + 1;
        }
        return ans;

    }

    public boolean isPossible(int[] a, double hour, int target) {

        double count = 0;
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            count += Math.ceil(Double.valueOf(a[i]) / target);

        }
        count += Double.valueOf(a[n - 1]) / target;
        return count <= hour;
    }
}

// https://leetcode.com/problems/minimum-speed-to-arrive-on-time/discuss/1226468/Binary-Answer-Cheat-sheet