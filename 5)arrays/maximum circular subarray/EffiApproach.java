
// IDEA : 
// maxOfNormalSubarray => by kaden's algo
// maxOfCircularSubarray =>total sum- minimumOfNormalSubarray
// max( maxOfNormalSubarray , maxOfCircularSubarray)

public class EffiApproach {
    public static void main(String[] args) {
        int[] arr = new int[] { 3, -4, 5, 6, -8, 7 };
        System.out.println(getOverallMaxSubarraySum(arr));
    }

    public static int getOverallMaxSubarraySum(int[] arr) {
        int max_circular, arr_sum = 0, max_normal = getMaxNormalSubarraySum(arr);
        if (max_normal < 0)
            return max_normal;

        // calculating total sum and reversing signs of each array element
        for (int i = 0; i < arr.length; i++) {
            arr_sum += arr[i];
            arr[i] = -arr[i];
        }

        // maxCirular= arr_sum - minimumOfNormalSubarray
        // maxCirular= arr_sum + maximumOfNormalSubarray

        max_circular = arr_sum + getMaxNormalSubarraySum(arr);
        return max_circular;
    }

    public static int getMaxNormalSubarraySum(int[] arr) {
        int res = arr[0], n = arr.length, maxending = arr[0];
        for (int i = 1; i < n; i++) {
            maxending = Math.max(maxending + arr[i], arr[i]);
            res = Math.max(res, maxending);
        }
        return res;

    }
}
// Time Complexity : theta(n)
