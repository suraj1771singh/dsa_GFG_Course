import java.util.Scanner;

/**
 * EffiApproach
 */
public class EffiApproach {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuilder newStr = new StringBuilder();
        newStr.append(str);
        printPowerSet(newStr);
        scanner.close();
    }

    public static void printPowerSet(StringBuilder str) {

        int len = str.length();
        int powerSetSize = (int) Math.pow(2, len);
        for (int i = 0; i < powerSetSize; i++) {
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) != 0)
                    System.out.print(str.charAt(j));
            }
            System.out.println();
        }
    }
}
// Time complexity : Theta(2^n * n)