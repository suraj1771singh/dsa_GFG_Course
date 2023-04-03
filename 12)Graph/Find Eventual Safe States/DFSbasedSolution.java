import java.util.ArrayList;
import java.util.List;

//a vertex will always end with terminal node, if it is not in a loop
//this means a vertex is safe if that vertex is not a part of any loop

public class DFSbasedSolution {
    enum State {
        SAFE, UNSAFE
    };

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<Integer> ans = new ArrayList<>();
        State[] state = new State[V];
        for (int i = 0; i < V; i++) {
            if (DFS(i, state, graph))
                // add those vertices which are not in any cycle
                ans.add(i);
        }
        return ans;
    }

    public boolean DFS(int source, State[] state, int[][] graph) {
        // when node is already visited
        if (state[source] != null)
            // if node is safe(1) then return true, else return false
            return state[source] == State.SAFE;
        // mark node as visited and unsafe for now
        state[source] = State.UNSAFE;
        // dfs to its neighbours
        for (int x : graph[source]) {
            // if atleast one neighbour is in cycle , means current node is also include in
            // a cycle ,so return false
            if (!DFS(x, state, graph))
                return false;
        }
        // if node is not in any cycle , mark it safe and return true;
        state[source] = State.SAFE;
        return true;
    }

}
