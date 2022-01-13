
/**
 * NaiveApproach
 */
public class NaiveApproach {

    public static void main(String[] args) {
        // left rotate by one
        // then repeate it d times
        int[] arr = new int[] { 10, 20, 30, 40, 50 };
        int d = 4;
        leftRotate(arr, d);

    }

    // left rotate by d
    public static void leftRotate(int[] arr, int d) {
        for (int i = 0; i < d; i++) {
            leftRotateByOne(arr);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // left rotate by 1
    public static void leftRotateByOne(int[] arr) {
        int firstElement = arr[0];
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1];

        }
        arr[n - 1] = firstElement;
    }
}

// Time complexity : theta(n*d)
