import java.util.Scanner;

public class EfficientMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(countTrailingZeros(n));
    }

    public static int countTrailingZeros(int n) {
        int ans = 0;
        for (int i = 5; i <= n; i *= 5)
            ans += n / i;
        return ans;
    }
}

// numberOfZeros=floor(n/pow(5,1))+floor(n/pow(5,2))+floor(n/pow(5,3)).....until
// it will be 0

// Time complexity: theta(logn)