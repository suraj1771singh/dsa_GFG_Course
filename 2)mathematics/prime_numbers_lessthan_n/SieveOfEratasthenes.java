import java.util.HashMap;
import java.util.Scanner;

public class SieveOfEratasthenes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        getPrimeNumberslesssThanN(n);

    }

    public static void getPrimeNumberslesssThanN(int n) {
        HashMap<Integer, Boolean> isPrime = new HashMap<Integer, Boolean>();
        // initialising every value true
        for (int i = 0; i <= n; i++) {
            isPrime.put(i, true);
        }

        // setting multiples of i as false
        for (int i = 2; i * i <= n; i++) {
            if (isPrime.get(i)) {
                for (int j = 2 * i; j <= n; j = j + i)
                    isPrime.replace(j, false);
            }
        }
        // printing only thoes vaues which are prime(true)
        for (int i = 2; i <= n; i++) {
            if (isPrime.get(i))
                System.err.print(i + " ");
        }

    }

}
