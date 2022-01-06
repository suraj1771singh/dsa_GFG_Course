import java.util.Scanner;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class fabonicci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        getFabonicci(n, 0, 1);

    }

    public static void getFabonicci(int n, int a, int b) {

        if (n == 1) {
            System.out.print(a + " ");
            return;
        }

        System.out.print(a + " ");
        getFabonicci(n - 1, b, a + b);
    }
}