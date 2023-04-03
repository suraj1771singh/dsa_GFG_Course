// RECURSION

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return f(0, k, arr);
    }

    public int f(int i, int k, int[] arr) {
        if (i == arr.length)
            return 0;
        int len = 0;
        int maxiSum = 0;
        int maxiElemt = -1;
        for (int j = i; j < Math.min(k + i, arr.length); j++) {
            len++;
            maxiElemt = Math.max(maxiElemt, arr[j]);
            int sum = maxiElemt * (len) + f(j + 1, k, arr);
            maxiSum = Math.max(maxiSum, sum);
        }
        return maxiSum;

    }

}
// Time Complexity: exponential
// Space Complexity : O(n)