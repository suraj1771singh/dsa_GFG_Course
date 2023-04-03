import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] x : edges) {
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
        }

        int mini = (int) Math.pow(10, 7);
        int[][] dp = new int[n][n];
        for (int[] x : dp)
            Arrays.fill(x, -1);
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            int maxdist = DFS(adj, i, visited, 0, dp);
            if (mini > maxdist) {
                ans.clear();
                ans.add(i);
                mini = maxdist;

            } else if (mini == maxdist)
                ans.add(i);

        }
        return ans;

    }

    public int DFS(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, int dist, int[][] dp) {
        int mini = dist;
        visited[s] = true;

        for (int x : adj.get(s)) {

            if (!visited[x]) {
                if (dp[s][x] != -1)
                    return dp[s][x];
                else {
                    mini = Math.max(mini, DFS(adj, x, visited, dist + 1, dp));
                    dp[s][x] = mini;
                }

            }
        }

        return mini;
    }
}