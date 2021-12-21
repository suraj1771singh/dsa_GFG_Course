import java.util.Scanner;


public class Approach1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        scanner.nextLine();
        int k = scanner.nextInt();
        kthBit(x, k);
    }

    public static void kthBit(int x, int k) {
        if ((x & (1 << (k - 1))) != 0)
            System.out.println("Set");
        else
            System.out.println("Not set");

    }
}