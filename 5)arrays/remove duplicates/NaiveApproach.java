import java.util.Scanner;

/**
 * NaiveApproach
 */
public class NaiveApproach {

    public static void main(String[] args) {
        int[] arr = { 10, 10, 10, 20, 20, 20, 30 };
        int index = removeDuplicates(arr);
        for (int i = 0; i < index; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static int removeDuplicates(int arr[]) {
        int res = 1, n = arr.length;
        int[] temp = new int[n];
        temp[0] = arr[0];

        // separating duplicates to temp array
        for (int i = 1; i < arr.length; i++) {
            if (temp[res - 1] != arr[i]) {
                temp[res] = arr[i];
                res++;
            }
        }
        // copying elements to original array
        for (int i = 0; i < res; i++) {
            arr[i] = temp[i];
        }
        return res;

    }
}

// Time complexity : theta(n)
// auxillary space : theta (n)