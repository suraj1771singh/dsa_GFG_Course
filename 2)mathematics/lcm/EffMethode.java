import java.util.Scanner;

public class EffMethode {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        scanner.nextLine();
        int b = scanner.nextInt();
        System.out.println(lcm(a, b));
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static int gcd(int a, int b) {

        if (b == 0)
            return a;
        else
            return gcd(b, a % b);

    }
}

// Time complexity : O(log(min(a,b)))
// this is TC of eculidean Methode 