
// Definition for a binary tree node.
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

class EffiAproach {
    public int countNodes(TreeNode root) {
        // calculate left height
        TreeNode curr = root;
        int lh = 0, rh = 0;
        while (curr != null) {
            lh++;
            curr = curr.left;
        }
        // calulate right height
        curr = root;
        while (curr != null) {
            rh++;
            curr = curr.right;
        }
        // id lh= rh then return 2^lh-1;
        if (rh == lh)
            return (int) Math.pow(2, lh) - 1;

        // else usse naive methode
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
// Time complexity : O( logn * log n)
// ASS :O(h) height of tree