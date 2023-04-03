import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int source) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((a, b) -> a.get(1) - (b.get(1)));
        dist[source] = 0;
        pq.add(new ArrayList<>(Arrays.asList(source, 0)));
        while (!pq.isEmpty()) {
            ArrayList<Integer> currEdge = pq.poll();
            if (currEdge.get(1) > dist[currEdge.get(0)])
                continue;
            for (ArrayList<Integer> edge : adj.get(currEdge.get(0))) {
                int v = edge.get(0);
                int w = edge.get(1);
                if (dist[v] > dist[currEdge.get(0)] + w) {
                    dist[v] = dist[currEdge.get(0)] + w;
                    pq.add(new ArrayList<>(Arrays.asList(v, dist[v])));
                }
            }

        }
        return dist;
    }
}
// Time complexity : O(E * log V)