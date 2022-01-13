/**
 * EffiApproach
 */
public class EffiApproach {

    public static void main(String[] args) {
        int[] arr = { 10, 0, 20, 0, 0, 30, 0, 40 };
        int index = moveZerosToLast(arr);
        for (int i = 0; i < index; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int moveZerosToLast(int arr[]) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                swap(arr, i, res);
                res++;
            }
        }
        return res;
    }

    public static void swap(int arr[], int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}
// Time complexity : theta(n)