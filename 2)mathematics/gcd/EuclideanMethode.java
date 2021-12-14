import java.util.Scanner;

public class EuclideanMethode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        scanner.nextLine();
        int b = scanner.nextInt();
        System.out.println(gcd(a, b));
    }

    public static int gcd(int a, int b) {

        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;

    }

}
// Time complexity : O(log(min(a,b)))