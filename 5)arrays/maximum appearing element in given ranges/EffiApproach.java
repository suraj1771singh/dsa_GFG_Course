import java.util.ArrayList;

// PROBLEM : given n ranges, find maxi appearing element in these ranges
// ------ l[]={1,2,5,15}
// ------ r[]={5,8,7,18}
// ------ output: 5

public class EffiApproach {

    public static void main(String[] args) {
        int[] l = new int[] { 1, 2, 5, 15 };
        int[] r = new int[] { 5, 8, 7, 18 };

        System.out.println(maxOccurringElement(l, r));
    }

    public static int maxOccurringElement(int[] l, int[] r) {
        int res = 0, n = l.length;
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = 0;

        }
        for (int i = 0; i < n; i++) {
            arr[l[i]]++;
            arr[r[i] + 1]--;

        }

        int max_occur = arr[0];
        for (int i = 1; i < 1000; i++) {
            arr[i] += arr[i - 1];
            if (max_occur < arr[i]) {
                max_occur = arr[i];
                res = i;
            }
        }

        return res;

    }
}
