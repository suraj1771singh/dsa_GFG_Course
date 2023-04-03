import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    // return is it bipartite
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                colors[i] = 0;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int next : graph[cur]) {
                        if (colors[next] == -1) {
                            colors[next] = 1 - colors[cur];
                            queue.offer(next);
                        } else if (colors[next] == colors[cur]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
// The algorithm to determine whether a graph is bipartite or not uses 
//the concept of graph colouring and BFS and finds it in O(V+E) 
//time complexity on using an adjacency list and O(V^2) on using adjacency matrix.