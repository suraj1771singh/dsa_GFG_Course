import java.util.PriorityQueue;

class Pair {
    int index;
    int val;

    Pair(int i, int v) {
        index = i;
        val = v;
    }
}

public class Solution {
    public int minCostConnectPoints(int[][] points) {
        int sum = 0;
        int n = points.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        boolean visited[] = new boolean[n];
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair currEdge = pq.poll();
            int v = currEdge.index;
            if (visited[v])
                continue;

            visited[v] = true;
            int w = currEdge.val;
            sum += w;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int weight = Math.abs(points[v][0] - points[i][0]) + Math.abs(points[v][1] - points[i][1]);
                    pq.add(new Pair(i, weight));
                }
            }

        }
        return sum;

    }

}