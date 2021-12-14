
import java.util.Scanner;

public class NaiveApproach {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        scanner.nextLine();
        int b = scanner.nextInt();
        System.out.println(lcm(a, b));
    }

    public static int lcm(int a, int b) {
        int ans = Math.max(a, b);
        while (true) {
            if (ans % a == 0 && ans % b == 0)
                return ans;
            ans++;
        }
    }
}

// Time complexity : O(a*b-max(a,b))