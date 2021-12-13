import java.util.Scanner;

public class NaiveApproach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(countzero(n));
    }

    public static int countzero(int n) {
        int ans = 0, fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        while (fact % 10 == 0) {
            ans++;
            fact = fact / 10;
        }
        return ans;

    }
}
