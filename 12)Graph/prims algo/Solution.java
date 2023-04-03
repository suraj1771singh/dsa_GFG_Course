
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        return prim(adj, V);
    }

    static int prim(ArrayList<ArrayList<ArrayList<Integer>>> adj, int V) {
        int sum = 0;
        boolean visited[] = new boolean[V];
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((a, b) -> a.get(1) - b.get(1));
        pq.add(new ArrayList<>(Arrays.asList(0, 0)));

        while (!pq.isEmpty()) {
            ArrayList<Integer> currEdge = pq.poll();
            if (visited[currEdge.get(0)])
                continue;
            // when vertices is not visited yet
            visited[currEdge.get(0)] = true;
            sum += currEdge.get(1);
            for (ArrayList<Integer> edge : adj.get(currEdge.get(0)))
                if (!visited[edge.get(0)])
                    pq.add(edge);

        }
        return sum;
    }

}
// Time complexity : O((V+E) * logV)
// in prims algo we consider connected, undirected graph, weighted graphs
// in connected graphs V<=|E|
// so
// Time complexity : O(( E * logV)