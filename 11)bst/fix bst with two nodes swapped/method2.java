
//-------USING SIMPLE CONCEPT OF INORDER TRAVERSAL
public class method2 {
    private TreeNode prev = null;
    private TreeNode first = null;
    private TreeNode second = null;

    public void recoverTree(TreeNode root) {
        // to calculate first and second node
        inorder(root);
        // now swap values;
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            if (prev != null && root.val < prev.val) {
                if (first == null)
                    first = prev;
                second = root;
            }
            prev = root;
            inorder(root.right);
        }
    }
}
// Time complexity : O(n);
// ASS : O(h)
