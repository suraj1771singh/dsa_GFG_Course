
public class RecursiveApproach {

    public static void main(String[] args) {
        System.out.println(fun(23, 11, 9, 12));
    }

    // return max
    public static int fun(int n, int a, int b, int c) {
        if (n == 0)
            return 0;
        if (n < 0)
            return -1;
        int ans = getMax(fun(n - a, a, b, c), fun(n - b, a, b, c), fun(n - c, a, b, c));
        if (ans == -1)
            return -1;
        return ans + 1;

    }

    public static int getMax(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);

    }
}
// Time complexity : o(3^n)