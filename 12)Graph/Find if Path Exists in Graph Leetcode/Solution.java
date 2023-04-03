import java.util.ArrayList;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n);
        getAdjList(adj, edges, n);
        boolean visited[] = new boolean[n];
        return DFS(adj, source, destination, visited);
    }

    public boolean DFS(ArrayList<ArrayList<Integer>> adj, int source, int destination, boolean[] visited) {
        if (source == destination)
            return true;
        visited[source] = true;
        for (int x : adj.get(source))
            if (!visited[x] && DFS(adj, x, destination, visited))
                return true;
        return false;
    }

    public void getAdjList(ArrayList<ArrayList<Integer>> adj, int[][] edges, int n) {
        for (int i = 0; i < n; i++)
            adj.add(i, new ArrayList<>());
        for (int[] x : edges) {
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
        }
    }
}