import java.util.Scanner;

public class NaiveApproach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println(isPrime(a));
    }

    public static boolean isPrime(int n) {
        if (n == 1)
            return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

}

// Time complexity : O(n)
