public class ReversalApproach {
    public static void main(String[] args) {
        int[] arr = new int[] { 10, 20, 30, 40, 50 };
        int d = 3; // d < arr.length
        leftRotate(arr, d);

    }

    // left rotate by d
    public static void leftRotate(int[] arr, int d) {
        int n = arr.length;
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);

        // printing array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

}

// Time complexity : Thet(n);
// Auxillary space: O(1)
