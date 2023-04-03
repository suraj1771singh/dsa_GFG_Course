import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Pair {
    TreeNode node;
    int hd;

    Pair(TreeNode a, int h) {
        node = a;
        int hd = h;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        f(root, map);
        for (Map.Entry i : map.entrySet()) {
            ans.add(((List<Integer>) i.getValue()));
        }
        return ans;

    }

    public void f(TreeNode root, TreeMap<Integer, ArrayList<Integer>> map) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode curr = p.node;
            int hd = p.hd;
            if (map.containsKey(hd)) {
                map.get(hd).add(curr.val);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(curr.val);
                map.put(hd, temp);
            }
            if (curr.left != null)
                q.add(new Pair(curr.left, hd - 1));
            if (curr.right != null)
                q.add(new Pair(curr.right, hd + 1));
        }
    }
}