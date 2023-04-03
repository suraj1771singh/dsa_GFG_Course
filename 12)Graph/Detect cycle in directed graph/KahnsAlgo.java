public class KahnsAlgo {
    // using Kahn's alogrithm
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // calculating indegree of every vertex
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int j : adj.get(i)) {
                indegree[j]++;
            }
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            count++;
            for (int v : adj.get(u)) {
                if (--indegree[v] == 0)
                    q.add(v);
            }
        }
        return count != V;
    }
}