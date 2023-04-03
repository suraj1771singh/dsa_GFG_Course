
// Definition for a binary tree node.
public class TreeNode {
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

// ------------METHODE 2
class Node extends TreeNode {
    int lval;

    Node(TreeNode a) {
        super(a.val, a.left, a.right);
        // else super();
        this.lval = 0;
    }

}

public class methode2 {

    public int kthSmallest(TreeNode root, int k) {
        Node newroot = new Node(root);
        return f(newroot, k);

    }

    public int f(Node root, int k) {
        if (root.lval + 1 == k) {
            root.lval++;
            return root.val;
        }
        if (root.lval + 1 > k)
            return f(new Node(root.left), k);
        else if (root.lval + 1 < k)
            return f(new Node(root.right), k - root.lval - 1);
        else
            return -1;
    }

}
