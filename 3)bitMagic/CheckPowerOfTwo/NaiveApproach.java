import java.util.Scanner;
public class NaiveApproach {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(isPowerOf2(n));
    }

    public static boolean isPowerOf2(int n) {
        if (n <= 0)
            return false;
        while (n != 1) {
            if (n % 2 != 0)
                return false;
            n = n >> 1;
        }
        return true;
    }
}
// Time complexity : O(log n)