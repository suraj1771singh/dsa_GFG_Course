//IDEA : precompute leftmax and rightmax using prefixMax and suffixMax table

public class EffiApproach {
    public static void main(String[] args) {
        int[] arr = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(getTappedWater(arr));
    }

    public static int getTappedWater(int[] arr) {
        int res = 0;
        // precalculate prefix max and suffix max array

        // prefix max array
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = Math.max(prefixSum[i - 1], arr[i]);
        }

        // suffix max array
        int[] suffixSum = new int[arr.length];
        suffixSum[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            suffixSum[i] = Math.max(suffixSum[i + 1], arr[i]);
        }

        for (int i = 1; i < arr.length - 1; i++) {
            res += Math.min(prefixSum[i], suffixSum[i]) - arr[i];
        }
        return res;
    }

}
// Time complexity : theta(n)
// auxiallary space : theta(n)
