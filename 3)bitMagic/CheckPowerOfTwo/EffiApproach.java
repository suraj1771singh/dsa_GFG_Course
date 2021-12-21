import java.util.Scanner;

public class EffiApproach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(isPowerOf2(n));
    }

    public static boolean isPowerOf2(int n) {
        // brain kaningam's formula
        return (n > 0) && ((n & (n - 1)) == 0);

    }
}
// Time complexity : Theta(1) constant time