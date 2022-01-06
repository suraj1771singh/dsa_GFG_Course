import java.util.Scanner;

public class SumOfDigits {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // simple recursion
        // System.out.println(fun(n));

        // tail recursion
        System.out.println(fun(n, 0));
    }

    // -------------simple recursion

    // public static int fun(int n) {
    // if (n == 0)
    // return n;
    // return fun(n / 10) + n % 10;
    // }

    // ------------tail recursion
    public static int fun(int n, int sum) {
        if (n == 0)
            return sum + n;
        return fun(n / 10, sum + n % 10);
    }
}

// Time complexity : theta(d)   d: number of digits