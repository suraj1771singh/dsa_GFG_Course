import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class Solution {

    // kruskal's algorithm
    public ArrayList<ArrayList<Integer>> kruskal(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjCopy = new ArrayList<>(adj);
        Collections.sort(adjCopy, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                return a.get(1) - b.get(1);
            }
        });
        int[] parent = new int[V];
        for (int i = 0; i < V; i++)
            parent[i] = i;
        for (ArrayList<Integer> edge : adjCopy) {
            int u = edge.get(0);
            int v = edge.get(1);
            int pu = find(u, parent);
            int pv = find(v, parent);
            if (pu != pv) {
                res.add(edge);
                parent[pu] = pv;
            }
        }
        return res;
    }

    public int find(int u, int[] parent) {
        if (parent[u] == u)
            return u;
        return find(parent[u], parent);
    }
}

// Time Complexity : O(E log E)