import java.util.Scanner;

public class EffiApproach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[] { 2, 3, 1, 1, 5, 5, 3, 2, 3, 8, 8 };
        findOddNumber(arr);
    }

    // XOR of all number present in a array
    public static void findOddNumber(int arr[]) {
        int len = arr.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = res ^ arr[i];
        }
        System.out.println(res);

    }
}
// Time complexity : Theta(n)   n: length of array