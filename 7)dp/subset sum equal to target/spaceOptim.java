import java.util.Arrays;

//space optimization

public class spaceOptim {

    static Boolean isSubsetSum(int N, int arr[], int sum) {
        // code here
        return f(arr, N, sum);
    }

    static Boolean f(int[] a, int n, int k) {

        Boolean[] prev = new Boolean[k + 1];
        for (int i = 0; i < k + 1; i++) {
            prev[i] = Boolean.FALSE;
        }

        prev[0] = true;
        if (a[0] <= k)
            prev[a[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            Boolean[] curr = new Boolean[k + 1];
            curr[0] = true;
            for (int target = 1; target <= k; target++) {

                Boolean notpick = prev[target];
                Boolean pick = false;
                if (target >= a[ind])
                    pick = prev[target - a[ind]];
                curr[target] = pick || notpick;

            }
            prev = curr;
        }
        return prev[k];
    }
}