import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

//using BINARY SEARCH   

class Solution {
    public int splitArray(int[] nums, int m) {
        int maxi = -1, sum = 0;
        for (int i : nums) {
            sum += i;
            maxi = Math.max(maxi, i);
        }
        // now apply binary in space [maxi, sum]
        int l = maxi, r = sum;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (isFeasible(nums, m, mid))
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;

    }

    // feasible if req<= m ,
    public boolean isFeasible(int[] nums, int m, int target) {
        int req = 1, sum = 0;
        for (int i : nums) {
            if (sum + i > target) {
                req++;
                sum = i;
            } else
                sum += i;
        }
        return req <= m;
    }
}