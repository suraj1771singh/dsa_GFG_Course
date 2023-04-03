import java.util.Arrays;

//using bellman ford algo
public class BellmanFordApproach {
    public int networkDelayTime(int[][] times, int n, int k) {
        int dist[] = new int[n + 1];
        Arrays.fill(dist, (int) Math.pow(10, 5));
        dist[k] = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            for (int[] edge : times) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (dist[v] > dist[u] + wt) {
                    dist[v] = dist[u] + wt;
                    flag = true;
                }
            }
            if (!flag)
                break;

        }
        // find max of dist
        int maxi = -1;
        for (int i = 1; i <= n; i++) {
            maxi = Math.max(maxi, dist[i]);
        }
        return maxi == (int) Math.pow(10, 5) ? -1 : maxi;

    }
}
