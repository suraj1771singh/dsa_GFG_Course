import java.util.Scanner;

/**
 * NaiveApproach
 */
public class NaiveApproach {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        getPrimeNumberslesssThanN(n);

    }

    public static void getPrimeNumberslesssThanN(int n) {
        for (int i = 1; i < n; i++) {
            if (isPrime(i))
                System.out.print(i + " ");
        }

    }

    public static boolean isPrime(int n) {
        if (n == 1)
            return false;
        if (n == 2 || n == 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        }
        return true;

    }
}

// Time Complexity : O(n*sqrt(n))