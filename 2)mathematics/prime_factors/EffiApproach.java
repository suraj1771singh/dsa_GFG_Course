import java.util.Scanner;

public class EffiApproach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        getPrimeFactors(n);
    }

    public static void getPrimeFactors(int n) {
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                System.out.print(i + " ");
                n = n / i;
            }
        }
        if (n > 1)
            System.out.print(n);
    }

}

// Time complexity -: O(sqrt(n)logn)
