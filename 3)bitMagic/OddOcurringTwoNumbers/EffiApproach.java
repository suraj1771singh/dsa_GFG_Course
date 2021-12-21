import java.util.Scanner;

/**
 * EffiApproach
 */
public class EffiApproach {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[] { 3,2, 3,3, 1, 1, 5, 5, 3, 3, 8, 8 };
        findOddNumbers(arr);
    }

    public static void findOddNumbers(int arr[]) {
        int len = arr.length;
        int xor = 0, res1 = 0, res2 = 0;
        for (int i = 0; i < len; i++) {
            xor = xor ^ arr[i];
        }
        // now idea is to get rightmost set bit of XOR, such that all other bits are 0
        // here we use formula n&~(n-1) =>
        // which returns rightmost set bit, all other are 0

        xor = xor &( ~(xor - 1));
        for (int i = 0; i < len; i++) {
            if ((xor & arr[i]) != 0)
                res1 = res1 ^ arr[i];
            else
                res2 = res2 ^ arr[i];
        }
        System.out.println(res1 + " " + res2);
    }
}
// Time complexity : Theta(n)  n : length of array