//PROBLEM : Equilibrium point is that point such that sum of elements before it is same as element after it.

//IDEA : check left and right sum of every element and check if it is equal or not

public class NaivApproach {

    public static void main(String[] args) {
        int[] arr = new int[] { -7, 1, 5, 2, -4, 3, 0 };
        System.out.println("Equilibrium found at index " + getEquilibriumPoint(arr));
    }

    public static int getEquilibriumPoint(int[] arr) {
        int res = -1, n = arr.length;
        for (int i = 0; i < n; i++) {
            int l_sum = 0, r_sum = 0;
            // left sum
            for (int j = i - 1; j >= 0; j--) {
                l_sum += arr[j];

            }
            // right sum
            for (int j = i + 1; j < n; j++) {
                r_sum += arr[j];

            }
            if (l_sum == r_sum) {
                res = i;
                break;
            }
        }
        return res;

    }
}
// Time Complexity : O(n^2)