import java.util.HashSet;



//-------USING HASHSET
class Solution {
    private HashSet<Integer> set = new HashSet();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        if (findTarget(root, k))
            return true;
        if (set.contains(k - root.val))
            return true;
        else
            set.add(root.val);
        return findTarget(root, k);

    }
}