
//recursion

public class recursiveApproach {

    public int cutRod(int price[], int n) {
        return f(price, n);
    }

    public int f(int a[], int target) {

        int maxi = 0;
        for (int i = 0; i < target; i++) {
            int value = a[i] + f(a, target - (i + 1));
            maxi = Math.max(maxi, value);
        }
        return maxi;
    }
}
// Time Complexity : O(n^n) : exponential
// Space Complexity :O(n)
