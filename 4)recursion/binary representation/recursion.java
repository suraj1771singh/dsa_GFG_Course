import java.security.Principal;
import java.util.Scanner;

/**
 * recursion
 */
public class recursion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        fun(n);
    }

    public static void fun(int n) {
        if (n == 0)
            return;
        fun(n / 2);
        System.out.print(n % 2);

    }
}