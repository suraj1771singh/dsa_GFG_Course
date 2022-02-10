
//IDEA : { min( leftmax(a[i]),rightMax(a[i]  ) - a[i]  }
// for each arr[i] find left and right max
public class NaiveApproach {

    public static void main(String[] args) {
        int[] arr = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(getTappedWater(arr));
    }

    public static int getTappedWater(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {

            // ---left max
            int lmax = arr[i];
            for (int j = 0; j < i; j++) {
                lmax = Math.max(lmax, arr[j]);
            }

            // --- right max
            int rmax = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                rmax = Math.max(rmax, arr[j]);
            }

            // ---min(rightmax, leftmax)
            res += (Math.min(lmax, rmax) - arr[i]);
        }

        return res;
    }
}
// Time complexity : theta(n^2)