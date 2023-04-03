import java.util.ArrayList;
import java.util.Stack;

public class Solution {

    // Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        boolean seen[] = new boolean[V];
        for (int i = 0; i < V; i++)
            if (!seen[i])
                dfs(i, seen, adj, st);

        // transpose of graph
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adjT.add(new ArrayList<>());
        for (int i = 0; i < V; i++)
            for (int u : adj.get(i))
                adjT.get(u).add(i);

        seen = new boolean[V];
        int scc = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            if (!seen[node]) {
                scc++;
                dfs2(node, seen, adjT);
            }
        }
        return scc;
    }

    void dfs(int node, boolean[] seen, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        seen[node] = true;
        for (int child : adj.get(node)) {
            if (!seen[child])
                dfs(child, seen, adj, st);
        }
        st.push(node);
    }

    void dfs2(int node, boolean[] seen, ArrayList<ArrayList<Integer>> adjT) {
        seen[node] = true;
        for (int child : adjT.get(node))
            if (!seen[child])
                dfs2(child, seen, adjT);
    }

}

// Time complexity :O(V+E)