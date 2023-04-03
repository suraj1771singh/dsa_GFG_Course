
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

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            else {
                TreeNode succ = getSucc(root);
                root.val = succ.val;
                root.right = deleteNode(root.right, succ.val);
            }
        }
        return root;
    }

    public TreeNode getSucc(TreeNode root) {
        root = root.right;
        while (root != null && root.left != null) {
            root = root.left;
        }
        return root;
        
    }
}
// Time Complexity : O(h) || h: heigth of bst
// ASS : O(h)