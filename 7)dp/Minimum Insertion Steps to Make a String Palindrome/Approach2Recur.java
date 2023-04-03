
//GFG

public class Approach2Recur {

    static int countMin(String str) {
        return f(str, 0, str.length() - 1);
    }

    static int f(String str, int i, int j) {
        if (i >= j)
            return 0;
        if (str.charAt(i) == str.charAt(j)) {
            return f(str, i + 1, j - 1);
        } else {
            return 1 + Math.min(f(str, i + 1, j), f(str, i, j - 1));
        }
    }
}