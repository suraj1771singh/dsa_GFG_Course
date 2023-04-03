import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

//GFG
class Solution implements Comparator<ArrayList<Integer>> {
    private int time = 0;
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
        return a.get(0) - b.get(0);
    }

    public ArrayList<ArrayList<Integer>> tarjans(int V, ArrayList<ArrayList<Integer>> adj) {

        int[] disc = new int[V];
        int[] low = new int[V];
        Stack<Integer> st = new Stack<>();
        boolean[] stackMember = new boolean[V];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);

        for (int i = 0; i < V; i++)
            if (disc[i] == -1)
                sccdfs(disc, low, i, st, stackMember, adj);

        // sorting res, according to question
        Collections.sort(res, new Solution());
        return res;

    }

    public void sccdfs(int disc[], int low[], int u, Stack<Integer> st, boolean stackMember[],
            ArrayList<ArrayList<Integer>> adj) {
        disc[u] = time;
        low[u] = time;
        time++;
        stackMember[u] = true;
        st.push(u);
        for (int v : adj.get(u)) {
            if (disc[v] == -1) {
                sccdfs(disc, low, v, st, stackMember, adj);
                // update low;
                low[u] = Math.min(low[v], low[u]);
            } else if (stackMember[v]) {
                // back edge => update low
                low[u] = Math.min(low[u], disc[v]);
            }
        }
        int w = -1;
        // if node is head

        if (low[u] == disc[u]) {
            ArrayList<Integer> scc = new ArrayList<>();
            while (w != u) {
                w = st.pop();
                scc.add(w);
                stackMember[w] = false;
            }
            Collections.sort(scc);
            res.add(scc);
        }
    }
}
// Time complexity : O(V+E ) for tarjan's algo
// but here we are doing sorting as well
// so TC : O(V+E)+ O(ElogE) + O(numberOfScc*logV)