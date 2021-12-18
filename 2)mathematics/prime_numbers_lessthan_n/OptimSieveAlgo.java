import java.util.Scanner;
import java.util.HashMap;

public class OptimSieveAlgo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        getPrimeNumberslesssThanN(n);

    }

    // some numbers are marked false again and again , we have to optimize this
    // we found pattern
    // mark false i*i, i*i +i , i*i + 2i-------------
    // in this way, we can skip already marked false keys

    public static void getPrimeNumberslesssThanN(int n) {
        HashMap<Integer, Boolean> isPrime = new HashMap<Integer, Boolean>();
        // initialising every value true
        for (int i = 0; i <= n; i++) {
            isPrime.put(i, true);
        }

        // setting multiples of i as false
        for (int i = 2; i <= n; i++) {
            if (isPrime.get(i)) {
                System.out.print(i + " ");
                for (int j = i * i; j <= n; j = j + i)
                    isPrime.replace(j, false);
            }
        }
    }

}

// Time Complexity : O(n * log logn)
// it is almost linear
