public class SlidingWindowApproach {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 8, 30, -5, 20, 7 };
        int k = 3;
        System.out.println(getMaxSum(arr, k));
    }

    public static int getMaxSum(int[] arr, int k) {
        int max_sum = 0, curr_sum = 0, n = arr.length;
        for (int i = 0; i < k; i++) {
            curr_sum += arr[i];
        }
        max_sum = curr_sum;
        for (int i = k; i < n; i++) {
            curr_sum += (arr[i] - arr[i - k]);
            max_sum = Math.max(max_sum, curr_sum);
        }
        return max_sum;
    }

}
// Time Complexity : theta(n)
