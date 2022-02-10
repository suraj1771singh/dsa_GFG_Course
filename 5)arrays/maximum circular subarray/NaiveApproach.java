
//IDEA : find sum of all possible subarrays and keep track for maximum

public class NaiveApproach {

    public static void main(String[] args) {
        int[] arr = new int[] { 3, -4, 5, 6, -8, 7 };
        System.out.println(getMax(arr));
    }

    public static int getMax(int[] arr) {
        int res = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            int curr_sum = arr[i];
            int curr_max = arr[i];
            for (int j = 1; j < n; j++) {
                int index = (i + j) % n;
                curr_sum += arr[index];
                curr_max = Math.max(curr_max, curr_sum);
            }
            res = Math.max(res, curr_max);
        }
        return res;
    }
}
// Time Complexity: theta(n^2)