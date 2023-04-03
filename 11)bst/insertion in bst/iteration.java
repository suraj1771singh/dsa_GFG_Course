
//  Definition for a binary tree node.
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

// ---------ITERATIVE
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode temp = new TreeNode(val);
        TreeNode parent = null;
        TreeNode curr = root;
        if (curr == null)
            return temp;
        while (curr != null) {
            parent = curr;
            if (val < curr.val)
                curr = curr.left;
            else if (val > curr.val)
                curr = curr.right;
            else
                return root;
        }
        if (val < parent.val)
            parent.left = temp;
        else
            parent.right = temp;
        return root;
    }
}