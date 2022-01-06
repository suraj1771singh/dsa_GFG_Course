/**
 * subset
 */
public class subset {

    public static void main(String[] args) {
        String s = "suraj";
        String curr = "";
        powerSet(s, curr, 0);

    }

    static void powerSet(String s, String curr, int i) {
        if (i == s.length()) {
            System.out.println(curr + " ");
            return;
        }

        powerSet(s, curr, i + 1);
        powerSet(s, curr + s.charAt(i), i + 1);

    }
}
// Time complexity : theta(2^n)