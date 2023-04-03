
import java.util.ArrayList;
import java.util.*;

public class NaiveApproach {
    public static int aggressiveCows(ArrayList<Integer> stalls, int k) {
        int maxi = 0, ans = -1;
        for (int i : stalls) {
            maxi = Math.max(maxi, i);
        }

        Collections.sort(stalls);

        for (int i = 1; i <= maxi; i++) {
            int count = 1;
            int lastone = stalls.get(0);
            for (int j : stalls) {
                if (j - lastone >= i) {
                    count++;
                    lastone = j;
                }
            }
            if (count < k)
                return ans;
            ans = i;
        }
        return ans;
    }
}
// Time complexity : O(n^2)
// Space Complexity : O(1)