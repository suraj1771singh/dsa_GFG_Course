
//IDEA : 
// 1) calculate total sum 
// 2) keep track of left Sum while traversing
// 3) check if left sum == total -left sum - arr[i]
//---- in this way auxilary space will be O(1
;

public class OptimPrefixSumApproach {
    public static void main(String[] args) {
        int[] arr = new int[] { -7, 1, 5, 2, -4, 3, 0 };
        System.out.println("Equilibrium found at index " + getEquilibriumPoint(arr));
    }

    public static int getEquilibriumPoint(int[] arr) {
        int res = -1, n = arr.length;
        int l_sum = 0, sum = 0;

        // calculating total sum of array
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        // checking if left sum is equal or not
        for (int i = 0; i < n; i++) {
            if (l_sum == sum - l_sum - arr[i]) {
                res = i;
                break;
            }
            l_sum += arr[i];
        }
        return res;
    }

}
// Time Complexity : O(n)
// Auxilary space : O(1)
