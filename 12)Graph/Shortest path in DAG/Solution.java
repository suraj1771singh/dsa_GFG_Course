// { Driver Code Starts
//Initial Template for Java

import java.io.*;

import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minStep(n));
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution {
    static int minStep(int n) {
        Stack<Integer> st = new Stack<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] dist = new int[n + 1];

        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
            adj.add(i, new ArrayList<>());

        }
        for (int i = 1; i <= n; i++) {

            if (i + 1 <= n)
                adj.get(i).add(i + 1);
            if (3 * i <= n)
                adj.get(i).add(3 * i);
        }

        topsort(st, adj, n);

        dist[st.peek()] = 0;
        while (!st.isEmpty()) {
            int u = st.pop();
            for (int v : adj.get(u)) {
                if (dist[v] > dist[u] + 1)
                    dist[v] = dist[u] + 1;
            }
        }
        return dist[n];
    }

    static void topsort(Stack<Integer> st, ArrayList<ArrayList<Integer>> adj, int n) {
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++)
            if (!visited[i])
                DFS(i, st, adj, n, visited);
    }

    static void DFS(int source, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj, int n, boolean[] visited) {
        visited[source] = true;
        for (int x : adj.get(source))
            if (!visited[x])
                DFS(x, st, adj, n, visited);
        st.push(source);
    }
}

//find number of nodes in binary tree