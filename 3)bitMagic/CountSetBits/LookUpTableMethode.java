import java.util.Scanner;

public class LookUpTableMethode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println("Number of Set bits : " + numberOfSetBits(x));
    }

    public static int numberOfSetBits(int n) {
        int count = 0;
        // initialize table
        int[] table = new int[256];
        table[0] = 0;
        for (int i = 0; i < 256; i++) {
            table[i] = (i & 1) + table[i / 2];
        }

        count = count + table[n & 0xff];
        n = n >> 8;
        count = count + table[n & 0xff];
        n = n >> 8;
        count = count + table[n & 0xff];
        n = n >> 8;
        count = count + table[n & 0xff];

        return count;
    }
}

// Time complexity : Theta(1) constant amount of time
