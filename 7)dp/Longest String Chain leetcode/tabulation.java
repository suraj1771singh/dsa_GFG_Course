
import java.util.Arrays;
import java.util.Comparator;

//make a comparator to sort array of strings
class MyComparator implements Comparator<String> {
    public int compare(String a, String b) {
        return a.length() - b.length();
    }
}

class tabulation {
    public int longestStrChain(String[] words) {
        int n = words.length;
        // sort array
        // we are sorting here because we are allowed to change order of longest string
        // subsequence
        Arrays.sort(words, new MyComparator());
        int dp[][] = new int[n + 1][n + 1];
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int prev = ind - 1; prev >= -1; prev--) {

                int notPick = dp[ind + 1][prev + 1];
                int pick = 0;
                if (prev == -1 || isPossible(ind, prev, words)) {
                    pick = 1 + dp[ind + 1][ind + 1];
                }
                dp[ind][prev + 1] = Math.max(notPick, pick);
            }
        }

        return dp[0][0];
    }

    private boolean isPossible(int ind, int prev, String[] arr) {
        String s1 = arr[ind], s2 = arr[prev];
        boolean diff = false;
        if (s1.length() != 1 + s2.length())
            return false;
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
                diff = true;
            }
        }
        if (!diff)
            return true;
        if (i == s1.length() && j == s2.length())
            return true;
        return false;

    }

}