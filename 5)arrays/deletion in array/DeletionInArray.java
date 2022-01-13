/**
 * DeletionInArray
 */
public class DeletionInArray {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6 };
        delete(arr, arr.length, 5);
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    public static void delete(int[] arr, int n, int k) {
        int i = 0;
        for (; i < n; i++) {
            if (arr[i] == k)
                break;
        }
        if (i == n)
            System.out.println("Not found");
        for (int j = i; j < n - 1; j++) {
            arr[j] = arr[j + 1];
        }

    }
}