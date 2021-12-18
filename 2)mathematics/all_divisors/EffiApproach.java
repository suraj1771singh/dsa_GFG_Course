import java.util.Scanner;

public class EffiApproach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        getDivisors(n);
    }

    public static void getDivisors(int n) {
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                if (i != n / i && n != n / i)
                    System.out.print(n / i + " ");
            }
        }
    }
}

// Time complexity : theta(sqrt(n))