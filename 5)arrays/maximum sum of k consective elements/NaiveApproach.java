
//PROBLEM : find maxi sum of k consective elements in an array

//IDEA : find all subarrray of k length and keep track of maximum of sum;
public class NaiveApproach {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 8, 30, -5, 20, 7 };
        int k = 3;
        System.out.println(getMaxSum(arr, k));
    }

    public static int getMaxSum(int[] arr, int k) {
        int res = 0, n = arr.length;
        for (int i = 0; i + k - 1 < n; i++) {
            int curr_sum = 0;
            for (int j = 0; j < k; j++)
                curr_sum = curr_sum + arr[i + j];
            res = Math.max(res, curr_sum);
        }
        return res;
    }
}

// Time Complexity : O(n^2)