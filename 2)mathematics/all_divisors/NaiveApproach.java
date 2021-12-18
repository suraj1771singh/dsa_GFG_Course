import java.util.Scanner;

public class NaiveApproach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        getDivisors(n);

    }

    public static void getDivisors(int n) {
        for (int i = 1; i < n; i++) {
            if (n % i == 0)
                System.out.print(i + " ");
        }
    }
}

// Time complexity : theta(n)
