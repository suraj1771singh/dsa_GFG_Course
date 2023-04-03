import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

class Main {

    public static void main(String[] args) {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter o = new PrintWriter(System.out);
        try {
            String[] s = r.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int[][] a = new int[n][2];
            for (int i = 0; i < n; i++) {
                String[] str = r.readLine().split(" ");
                a[i][0] = Integer.parseInt(str[0]);
                a[i][1] = Integer.parseInt(str[1]);
            }
            int[][] dp = new int[k + 1][n];
            for (int[] c : dp) {

                Arrays.fill(c, -1);
            }
            if (isPossible(a, k, n - 1, dp))
                o.println("Yes");
            else
                o.println("No");
        } catch (Exception e) {
            o.println(e);
        }
        o.close();

    }

    public static boolean isPossible(int[][] a, int target, int n, int[][] dp) {
        if (n == 0) {

            return target == a[0][0] || target == a[0][1];

        }
        if (dp[target][n] != -1)
            return dp[target][n] == 1 ? true : false;

        boolean mov1 = false;
        boolean mov2 = false;
        if (target >= a[n][0])
            mov1 = isPossible(a, target - a[n][0], n - 1, dp);
        if (target >= a[n][1])
            mov2 = isPossible(a, target - a[n][1], n - 1, dp);
        boolean res = mov1 || mov2;
        if (res)
            dp[target][n] = 1;
        else
            dp[target][n] = 0;
        return res;
    }
}