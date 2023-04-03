import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int[] outdegree = new int[V];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> incomingedges = new ArrayList<>();
        // initialzing 2D arraylist
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            incomingedges.add(i, new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            // calculating outdegree
            outdegree[i] = graph[i].length;
            // keeping track of indegrees for each vertices
            for (int j : graph[i])
                incomingedges.get(j).add(i);

        }
        // adding vertices having outdegree to queue
        for (int i = 0; i < V; i++) {
            if (outdegree[i] == 0)
                q.add(i);
        }

        // keep adding vertices in queue till when we are getting vertices with
        // outdegreee 0
        while (!q.isEmpty()) {
            int u = q.poll();
            ans.add(u);
            for (int v : incomingedges.get(u)) {
                if (--outdegree[v] == 0)
                    q.add(v);

            }
        }
        Collections.sort(ans);
        return ans;

    }
}