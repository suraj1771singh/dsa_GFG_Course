public class EffiSoution {

    // ------------Efficient solution

    public boolean isBalanced(TreeNode root) {
        if (f(root) == -1)
            return false;
        else
            return true;
    }

    public int f(TreeNode root) {
        if (root == null)
            return 0;
        int lh = f(root.left);
        if (lh == -1)
            return -1;
        int rh = f(root.right);
        if (rh == -1)
            return -1;
        if (Math.abs(lh - rh) > 1)
            return -1;
        else
            return 1 + Math.max(lh, rh);
    }

}
// Time Complexity : O(n)
// Space Complexity : O(n)