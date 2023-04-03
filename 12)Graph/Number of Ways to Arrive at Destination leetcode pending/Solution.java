import java.util.*;

class Solution {

    TreeMap<Integer, Integer> map = new TreeMap<>();

    public int countPaths(int n, int[][] roads) {
        int res = 0;
        Map<Integer, Map<Integer, Integer>> graph = buildTree(roads);
        boolean visited[] = new boolean[n];
        System.out.println(graph);
        dfs(0, roads.length - 1, graph, visited, 0);
        res = map.firstEntry().getValue();
        return res;
    }

    public void dfs(int src, int dest, Map<Integer, Map<Integer, Integer>> graph, boolean visited[], int wt) {
        visited[src] = true;
        if (src == dest) {
            Integer i = map.putIfAbsent(wt, 1);
            if (i != null)
                map.put(wt, i + 1);
            visited[src] = false;
            return;
        }
        for (Integer v : graph.get(src).keySet()) {
            if (!visited[v]) {
                wt += graph.get(src).get(v);
                dfs(v, dest, graph, visited, wt);
                wt -= graph.get(src).get(v);
            }
        }
        visited[src] = false;

    }

    public Map<Integer, Map<Integer, Integer>> buildTree(int[][] roads) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] edge : roads) {
            map.putIfAbsent(edge[0], new HashMap<>(edge[1], edge[2]));
            map.putIfAbsent(edge[1], new HashMap<>(edge[0], edge[2]));

            map.get(edge[0]).put(edge[1], edge[2]);
            map.get(edge[1]).put(edge[0], edge[2]);
        }
        return map;
    }

}