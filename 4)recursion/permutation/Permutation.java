import java.util.Scanner;

/**
 * Permutation
 */
public class Permutation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        permute(str, 0, str.length() - 1);

    }

    public static void permute(String s, int l, int r) {
        if (l == r)
            System.out.println(s);
        else {
            for (int i = l; i <= r; i++) {
                s = swap(s, l, i);
                permute(s, l + 1, r);
                swap(s, l, i);
            }
        }

    }

    public static String swap(String s, int i, int j) {
        char temp;
        char[] charArray = s.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);

    }
}

// Time Complexity : Theta(n!) : n is the length of string