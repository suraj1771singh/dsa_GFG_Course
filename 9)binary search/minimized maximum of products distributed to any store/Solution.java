
//BINARY SEARCH 

class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int maxi = -1, ans = -1;
        for (int i : quantities)
            maxi = Math.max(maxi, i);
        // Search spave is [1,maxi]
        int l = 1, h = maxi;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (isFeasible(quantities, n, mid)) {
                ans = mid;
                h = mid - 1;
            } else
                l = mid + 1;
        }
        return ans;
    }

    public boolean isFeasible(int[] a, int n, int target) {
        int req = 0;
        for (int i : a) {
            req += i / target;
            req += i % target == 0 ? 0 : 1;
        }
        return req <= n;
    }
}

// Time Complexity : O(m* log(maxi)) , m: length of quantities

// Similar questions in leetcode

// => Koko Eating Bananas