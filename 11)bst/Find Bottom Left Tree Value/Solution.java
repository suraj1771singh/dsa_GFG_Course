
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

class Solution {
    int maxLevel = -1;
    int ans = 0;

    public int findBottomLeftValue(TreeNode root) {
        inorder(root, 0);
        return ans;
    }

    public void inorder(TreeNode root, int level) {
        if (root == null)
            return;
        inorder(root.left, level + 1);
        if (level > maxLevel) {
            maxLevel = level;
            ans = root.val;
        }
        inorder(root.right, level + 1);
    }
}