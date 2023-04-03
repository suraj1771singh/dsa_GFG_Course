import java.util.ArrayList;
import java.util.Stack;

public class DfsBasedApproach {

    // DFS based algo
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[V];
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                DFS(i, adj, visited, st);
        }
        int index = 0;
        while (!st.isEmpty())
            ans[index++] = st.pop();
        return ans;

    }

    static void DFS(int s, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st) {
        visited[s] = true;
        for (int x : adj.get(s))
            if (!visited[x])
                DFS(x, adj, visited, st);
        st.push(s);
    }
}