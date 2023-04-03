

class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int[] dp = new int[arr.length];

        dp[0] = 1;
        if (arr.length == 1) {
            return 1;
        }
        if (arr.length == 2 && (arr[1] != arr[0])) {
            dp[1] = dp[0] + 1;
            return dp[1];
        }

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                dp[i] = dp[i - 1] + 1;
            } else if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                dp[i] = dp[i - 1] + 1;
            } else if (arr[i] == arr[i + 1] && arr[i] == arr[i - 1]) {
                dp[i] = 0;
            } else {
                dp[i] = 1;
            }
        }

        int v_max = 0;
        for (int j = 1; j < arr.length; j++) {
            // System.out.print(dp[j] + " ");
            if (v_max < dp[j]) {
                v_max = dp[j];
            }
        }

        return v_max + 1;
    }
}