
/**
 * OptimEculideanMethode
 */
import java.util.Scanner;

public class OptimEculideanMethode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        scanner.nextLine();
        int b = scanner.nextInt();
        System.out.println(gcd(a, b));
    }

    public static int gcd(int a, int b) {

        if (b == 0)
            return a;
        else
            return gcd(b, a % b);

    }

}