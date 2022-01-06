import java.util.Scanner;

/**
 * recursion2
 */
public class recursion2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fun(n));
    }

    public static int fun(int n) {
        if (n == 1)
            return 0;
        else
            return 1 + fun(n / 2);
    }
}