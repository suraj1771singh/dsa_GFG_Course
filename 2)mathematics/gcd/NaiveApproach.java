import java.util.Scanner;

public class NaiveApproach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        scanner.nextLine();
        int b = scanner.nextInt();
        System.out.println(gcd(a, b));
    }

    public static int gcd(int a, int b) {

        int ans = Math.min(a, b);
        while (ans > 0) {
            if (a % ans == 0 && b % ans == 0)
                break;
            ans--;
        }
        return ans;

    }

}

// Time complexity -: big O (min(a,b))
// space complexity: theta(1)
