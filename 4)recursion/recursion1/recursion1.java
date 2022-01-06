import java.util.Scanner;

public class recursion1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        fun(n);
    }

    public static void fun(int n) {
        if (n == 0)
            return;
        System.out.println(n);
        fun(n - 1);
        System.out.println(n);

    }
}

// Time complexity : theta(n)