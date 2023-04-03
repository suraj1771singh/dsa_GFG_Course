
//using disjoint set DS
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int parent[] = new int[n + 1];
        int candidate1[] = new int[2];
        int candidate2[] = new int[2];
        for (int i = 0; i <= n; i++)
            parent[i] = i;
        // first check two parent case
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (parent[v] != v) {
                // if there are multiple parent
                candidate1 = new int[] { u, v };
                candidate2 = new int[] { parent[v], v };
                edge[1] = -1;
            }
            parent[v] = u;
        }
        // we are assuming that candidate1 is the ans,
        // to verify we have check cycle is still present or not
        for (int i = 0; i <= n; i++)
            parent[i] = i;
        boolean isCycle = false;
        int candidate3[] = new int[2];
        for (int[] edge : edges) {
            if (edge[1] == -1)
                continue;
            int u = edge[0];
            int v = edge[1];
            int x = find(u, parent);
            int y = find(v, parent);
            if (x == y) {
                // cycle present
                isCycle = true;
                candidate3 = new int[] { u, v };
                break;
            }
            parent[v] = u;
        }

        if (!isCycle) {
            // if there is not a cycle
            // this means we assumed right ans and we removed correct edge
            return candidate1;
        }
        // if there is stil a cycle
        // case 1: we removed wrong edge, if there is 2 parent case
        // case 2: if there is no 2 parent case, then edge making cycle should be
        // removed
        if (candidate1[0] == 0 && candidate1[1] == 0) {
            // if there is no 2 parent case(case 2)
            return candidate3;
        } else
            return candidate2;

    }

    public int find(int x, int[] parent) {
        if (parent[x] == x)
            return x;
        return find(parent[x], parent);
    }
}