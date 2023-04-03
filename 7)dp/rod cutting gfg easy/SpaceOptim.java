
//tabulation

public class SpaceOptim {

    public int cutRod(int price[], int n) {
        return f(price, n);
    }

    public int f(int a[], int target) {
        int prev = 0;
        int curr = 0;
        for (int t = 0; t <= target; t++) {
            int maxi = 0;
            for (int i = 0; i < t; i++) {
                int value = a[i] + prev;
                maxi = Math.max(maxi, value);
            }
            curr = maxi;
            prev = curr;
        }

        return prev;
    }
}

// Time Complexity : O(n^2)
// Space Complexity :O(n)