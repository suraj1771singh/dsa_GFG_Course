/**
 * WindowSlidingApproach
 */
public class WindowSlidingApproach {

    public static void main(String[] args) {
        int n = 2;
        printNboniciNumbers(n);
    }

    public static void printNboniciNumbers(int n) {
        int sum = 0;
        int[] arr = new int[20];
        arr[0] = 1;

        for (int i = 0; i < n; i++) {
            arr[i] = 0;
        }
        arr[n - 1] = 1;
        arr[n] = 1;
        sum = 2;
        for (int i = n + 1; i < 20; i++) {
            arr[i] = sum;
            sum = (2 * sum - arr[i - n]);

        }
        for (int i = 0; i < 20; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
// Time complexity : O(number of terms)
// Auxiliary Space: O(n)