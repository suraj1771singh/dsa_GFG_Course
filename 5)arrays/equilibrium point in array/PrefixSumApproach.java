
//IDEA : precalculate prefix sum and postfix sum array
//       then check l_sum   [i-1]==r_sum[i+1]

public class PrefixSumApproach {
    public static void main(String[] args) {
        int[] arr = new int[] { -7, 1, 5, 2, -4, 3, 0 };
        System.out.println("Equilibrium found at index " + getEquilibriumPoint(arr));
    }

    public static int getEquilibriumPoint(int[] arr) {
        int res = -1, n = arr.length;
        int[] l_sum = new int[n];
        int[] r_sum = new int[n];

        // calculating prefix sum array
        l_sum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            l_sum[i] = l_sum[i - 1] + arr[i];
        }
        // calculating postfix sum array
        r_sum[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            r_sum[i] = r_sum[i + 1] + arr[i];
        }
        // checking if left sum is equal or not
        for (int i = 1; i < n - 1; i++) {
            if (l_sum[i - 1] == r_sum[i + 1]) {
                res = i;
                break;
            }
        }
        return res;

    }
}
// Time Complexity : O(n)
// Auxilary space : O(n)
