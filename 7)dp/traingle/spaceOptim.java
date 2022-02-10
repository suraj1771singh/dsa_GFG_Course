import java.util.List;

public class spaceOptim {

    // space optimisation

    public int minimumTotal(List<List<Integer>> triangle) {

        return getminpath(triangle);

    }

    public int getminpath(List<List<Integer>> tri) {
        int m = tri.size();
        int n = tri.get(m - 1).size();
        int[] prev = new int[n];

        for (int j = 0; j < n; j++) {
            prev[j] = tri.get(n - 1).get(j);
        }

        int maxCol = n - 1;
        for (int i = m - 2; i >= 0; i--) {
            int[] curr = new int[maxCol];
            for (int j = 0; j < maxCol; j++) {
                int first = tri.get(i).get(j) + prev[j];
                int second = tri.get(i).get(j) + prev[j + 1];
                curr[j] = Math.min(first, second);

            }
            maxCol--;
            prev = curr;
        }
        return prev[0];

    }
}

// Time Complexity : O(n*m)
// space Complexity : O(n)
// n: the max length of col
// m : number of rows