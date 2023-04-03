import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    HashMap<Integer, Node> visitedMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        return dfs(node);

    }

    public Node dfs(Node node) {
        if (node == null)
            return null;

        Node newnode = new Node(node.val);

        visitedMap.put(newnode.val, newnode);
        ArrayList<Node> newList = new ArrayList<Node>();

        for (Node neigh : node.neighbors) {
            if (!visitedMap.containsKey(neigh.val))
                newList.add(dfs(neigh));
            else
                newList.add(visitedMap.get(neigh.val));
        }
        // update newnode list
        newnode.neighbors = newList;
        return newnode;

    }

}