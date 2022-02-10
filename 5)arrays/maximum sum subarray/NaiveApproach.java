// IDEA : check all possible subarray and track maximum sum

public class NaiveApproach {

    public static void main(String[] args) {
        int[] arr = new int[] { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println(getMax(arr));
    }

    public static int getMax(int[] arr) {
        int res = arr[0];
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                res = Math.max(res, sum);
            }
        }
        return res;

    }
}
// Time complexity : O(n^2)