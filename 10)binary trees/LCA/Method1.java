import java.util.ArrayList;

//Definition for a binary tree node.

//-------ALGO

// 1) find path of both p and q nodes 
// 2) compare their path, and  keep two pointers
// 3) curr and prev 
// 4) return prev as soon as curr doesn't match

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();
        TreeNode ans = null;

        if (findPath(path1, root, p) && findPath(path2, root, q)) {
            for (int i = 0; i < Math.min(path1.size(), path2.size()); i++) {
                if (path1.get(i) == path2.get(i))
                    ans = path1.get(i);
                else
                    break;
            }
        }
        return ans;
    }

    public boolean findPath(ArrayList<TreeNode> path, TreeNode root, TreeNode p) {
        if (root == null)
            return false;
        path.add(root);
        if (root == p)
            return true;
        boolean l = findPath(path, root.left, p);
        if (l)
            return true;
        boolean r = findPath(path, root.right, p);
        if (r)
            return true;
        path.remove(path.size() - 1);
        return false;

    }
}
// Time complexity : theta(n)+ theta(n) +theta(n)
// Space Complexity : O(n)
