import java.util.Scanner;

public class NaiveApproach {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println("Number of Set bits : " + numberOfSetBits(x));
    }

    public static int numberOfSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1)
                count++;
            n = n >> 1;
        }
        return count;

    }
}
// Time complexity : theta(number of bits in n)