import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            graph.putIfAbsent(x, new HashMap<>());
            graph.putIfAbsent(y, new HashMap<>());
            graph.get(x).put(y, values[i]);
            graph.get(y).put(x, 1 / values[i]);
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            if (!graph.containsKey(x) || !graph.containsKey(y)) {
                result[i] = -1.0;
            } else {
                result[i] = dfs(graph, x, y, new HashSet<>());
            }
        }
        return result;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String x, String y, HashSet hashSet) {
        if (x.equals(y)) {
            return 1.0;
        }
        if (!graph.containsKey(x) || hashSet.contains(x)) {
            return -1.0;
        }
        hashSet.add(x);
        for (String key : graph.get(x).keySet()) {
            double value = dfs(graph, key, y, hashSet);
            if (value != -1.0) {
                return value * graph.get(x).get(key);
            }
        }
        return -1.0;
    }

}