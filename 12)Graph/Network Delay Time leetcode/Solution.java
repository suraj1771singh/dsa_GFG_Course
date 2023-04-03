import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

//IDEA
//find shortest distance to all nodes from source , then find their maximum of shortest dist
//if for any node shortest dist is infinity , then return -1

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int res = 0;
        ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<>();
        buildGraph(graph, times, n);

        int shortestPath[] = dijkstra(graph, k, n);
        // finding max value
        for (int i = 1; i <= n; i++) {
            if (shortestPath[i] == (int) Math.pow(10, 5))
                return -1;
            res = Math.max(res, shortestPath[i]);
        }
        return res;

    }

    public void buildGraph(ArrayList<ArrayList<ArrayList<Integer>>> graph, int[][] times, int n) {
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<ArrayList<Integer>>());
        for (int[] edge : times) {
            ArrayList<Integer> temp = new ArrayList<Integer>(Arrays.asList(edge[0], edge[1], edge[2]));
            graph.get(edge[0]).add(temp);
        }
    }

    public int[] dijkstra(ArrayList<ArrayList<ArrayList<Integer>>> graph, int src, int V) {
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((a, b) -> a.get(2) - b.get(2));
        int dist[] = new int[V + 1];
        Arrays.fill(dist, (int) Math.pow(10, 5));
        dist[src] = 0;
        pq.add(new ArrayList<>(Arrays.asList(src, src, 0)));
        while (!pq.isEmpty()) {
            ArrayList<Integer> currEdge = pq.poll();
            if (currEdge.get(2) > dist[currEdge.get(1)])
                continue;
            for (ArrayList<Integer> edge : graph.get(currEdge.get(1))) {
                int v = edge.get(1);
                int w = edge.get(2);
                if (dist[v] > dist[currEdge.get(1)] + w) {
                    dist[v] = dist[currEdge.get(1)] + w;
                    pq.add(new ArrayList<>(Arrays.asList(edge.get(0), v, dist[v])));
                }
            }
        }
        return dist;

    }
}