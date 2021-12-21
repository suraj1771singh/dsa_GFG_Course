import java.util.Scanner;

public class NaiveApproach {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[] { 2, 3, 1, 1, 5, 5, 3, 2, 3, 8, 8 };
        findOddNumber(arr);
    }

    public static void findOddNumber(int arr[]) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int j = 0; j < len; j++) {
                if (arr[i] == arr[j])
                    count++;
            }
            if (count % 2 != 0) {
                System.out.println(arr[i]);
                break;
            }
        }

    }
}
// Time complexity : O(n*n)