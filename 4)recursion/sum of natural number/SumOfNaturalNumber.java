import java.util.Scanner;

/**
 * SumOfNaturalNumber
 */
public class SumOfNaturalNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(sumOfN(n));
    }

    public static int sumOfN(int n) {
        if (n == 0)
            return 0;
        return n + sumOfN(n - 1);

    }
}