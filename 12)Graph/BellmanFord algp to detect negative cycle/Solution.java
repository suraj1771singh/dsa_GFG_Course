import java.util.Arrays;

public class Solution {

    public int isNegativeWeightCycle(int n, int[][] edges) {
        int ans = bellmanFord(edges, n) ? 1 : 0;
        return ans;
    }

    public boolean bellmanFord(int[][] edges, int n) {
        boolean nextIteration = false;
        int dist[] = new int[n];
        Arrays.fill(dist, (int) Math.pow(10, 5));
        dist[0] = 0;
        for (int count = 0; count < n - 1; count++) {
            nextIteration = false;
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    nextIteration = true;
                }
            }
            if (!nextIteration) {
                return false;
            }
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if (dist[u] + w < dist[v]) {
                dist[v] = dist[u] + w;
                return true;
            }
        }
        return false;

    }

}

// Time Complexity :O(V*E)
