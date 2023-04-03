//recursion

class Solution {
    public int minCut(String s) {
        // subtraction at end because it is doing partitioning at after the end also
        return f(0, s.length(), s) - 1;

    }

    public int f(int i, int n, String s) {
        if (i == n)
            return 0;
        int mini = 2000;
        for (int j = i; j < n; j++) {
            if (isPalindrome(i, j, s)) {
                int count = 1 + f(j + 1, n, s);
                mini = Math.min(mini, count);
            }
        }
        return mini;
    }

    public boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}

// Time Complexity :exponential
// Space Complexity :O(n)