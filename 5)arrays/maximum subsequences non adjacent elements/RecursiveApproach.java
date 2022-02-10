import javax.swing.text.html.StyleSheet;

/**
 * RecursiveApproach
 */
public class RecursiveApproach {

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 2, 5, 10, 7 };
        System.out.println(f(arr, 4));
    }

    public static int f(int[] a, int index) {
        if (index == 0)
            return a[index];
        if (index < 0)
            return 0;
        int pick = a[index] + f(a, index - 2);
        int notPick = f(a, index - 1);
        return Math.max(pick, notPick);
    }
}