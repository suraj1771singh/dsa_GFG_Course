
//---------ITERATIVE

//   Definition for a binary tree node.
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

class iterative {

    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode ans = null;
        if (root == null)
            return null;
        while (root != null) {
            if (val < root.val)
                root = root.left;
            else if (val > root.val)
                root = root.right;
            else {
                ans = root;
                break;
            }
        }
        return ans;
    }
}