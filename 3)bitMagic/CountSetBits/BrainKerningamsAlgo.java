import java.util.Scanner;

public class BrainKerningamsAlgo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println("Number of Set bits : " + numberOfSetBits(x));
    }

    public static int numberOfSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n & (n - 1);
        }
        return count;

    }
}

// Time complexity : Theta(number of set bits in n)
