
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
    public boolean isValidBST(TreeNode root) {
        return f(Long.MIN_VALUE, Long.MAX_VALUE, root);
    }

    public boolean f(long l_limit, long r_limit, TreeNode root) {
        if (root == null)
            return true;
        if (root.val < r_limit && root.val > l_limit)
            return f(l_limit, root.val, root.left) && f(root.val, r_limit, root.right);
        return false;
    }

    // used long just to prevent overflow

}

// Time complexity : O(n)