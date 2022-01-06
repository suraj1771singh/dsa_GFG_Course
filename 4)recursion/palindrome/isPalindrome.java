import java.util.Scanner;

/**
 * isPalindrome
 */
public class isPalindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(fun(str, 0, str.length() - 1));
    }

    public static boolean fun(String str, int n, int m) {
        if (n >= m)
            return true;
        if (str.charAt(n) != str.charAt(m))
            return false;
        return fun(str, n + 1, m - 1);
    }
}

// Time complexity : o(n)