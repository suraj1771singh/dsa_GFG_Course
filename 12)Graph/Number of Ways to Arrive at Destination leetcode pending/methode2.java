import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class methode2 {
    public int countPaths(int n, int[][] roads) {
        Map<Integer, List<int[]>> graph = buildGraph(n, roads);
        long dist[] = dijkstra(n, graph);
        long dp[] = new long[n];
        System.out.println(Arrays.toString(dist));
        dp[0] = (long) 1;
        for (int i = 1; i < n; i++) {
            for (int[] edge : graph.get(i)) {
                int v = edge[0];
                int wt = edge[1];
                if (dist[i] - wt < dist[v])
                    continue;
                dp[i] += dp[v];
                dp[i] %= 1000000007;
            }
        }
        return (int) dp[n - 1];

    }

    public Map<Integer, List<int[]>> buildGraph(int n, int[][] roads) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int i = 0; i < n; i++)
            graph.put(i, new ArrayList());

        for (int[] e : roads) {
            graph.get(e[0]).add(new int[] { e[1], e[2] });
            graph.get(e[1]).add(new int[] { e[0], e[2] });
        }
        return graph;
    }

    // dijkistra algorithm to find shortes path to all nodes
    public long[] dijkstra(int n, Map<Integer, List<int[]>> graph) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> (int) (a[1] - b[1]));
        dist[0] = 0;
        pq.add(new long[] { 0, 0 });
        while (!pq.isEmpty()) {
            long[] currEdge = pq.poll();
            if (currEdge[1] > dist[(int) currEdge[0]])
                continue;
            for (int[] edge : graph.get(currEdge[0])) {
                int v = edge[0];
                int wt = edge[1];
                if (dist[v] > dist[(int) currEdge[0]] + wt) {
                    dist[v] = dist[(int) currEdge[0]] + wt;
                    pq.add(new long[] { v, dist[v] });
                }
            }
        }
        return dist;
    }

}
