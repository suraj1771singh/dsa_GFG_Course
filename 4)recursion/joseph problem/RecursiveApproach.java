/**
 * RecursiveApproach
 */
public class RecursiveApproach {

    public static void main(String[] args) {
        System.out.println(fun(90, 3));

    }

    public static int fun(int n, int k) {
        if (n == 1)
            return 0;
        return (fun(n - 1, k) + k) % n;

    }
}