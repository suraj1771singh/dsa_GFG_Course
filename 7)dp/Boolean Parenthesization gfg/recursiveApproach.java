//      gfg

class Solution {
    static int countWays(int n, String s) {
        return f(0, n - 1, true, s);
    }

    static int f(int i, int j, boolean isTrue, String s) {
        if (i == j) {
            if (isTrue)
                return s.charAt(i) == 'T' ? 1 : 0;
            else
                return s.charAt(i) == 'F' ? 1 : 0;

        }

        int ways = 0;
        for (int k = i + 1; k <= j; k += 2) {
            // when left is true
            int lt = f(i, k - 1, true, s);
            // when left is false
            int lf = f(i, k - 1, false, s);
            // when right is true;
            int rt = f(k + 1, j, true, s);
            // when right is false
            int rf = f(k + 1, j, false, s);

            if (s.charAt(k) == '|') {
                // if OR

                if (isTrue)
                    ways += lt * rt + lt * rf + lf * rt;
                else
                    ways += lf * rf;
            } else if (s.charAt(k) == '&') {
                // if AND

                if (isTrue)
                    ways += lt * rt;
                else
                    ways += lf * rf + lt * rf + lf * rt;
            } else if (s.charAt(k) == '^') {
                // if XOR

                if (isTrue) {
                    ways += lt * rf + lf * rt;
                } else
                    ways += lt * rt + lf * rf;
            }
        }
        return ways;
    }
}
// Time complexity : exponential
// Space Complexity :O(n)
