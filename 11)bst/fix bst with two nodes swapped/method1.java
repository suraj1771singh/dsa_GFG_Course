import java.util.ArrayList;
import java.util.List;

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

// -----------USING EXTRA ARRAY
class Solution {
    public void recoverTree(TreeNode root) {
        List<Long> ans = new ArrayList<>();
        // storing nodes value in array, in ascending order
        inorder(root, ans);
        Long prev = Long.MIN_VALUE;
        Long first = Long.MIN_VALUE;
        Long second = Long.MIN_VALUE;
        for (Long i : ans) {
            if (i < prev) {
                if (first == Long.MIN_VALUE) {
                    first = prev;
                }
                second = i;
            }
            prev = i;
        }
        // now we have required swapped nodes so swap them
        swap(root, first, second);

    }

    public void inorder(TreeNode root, List<Long> arr) {
        if (root != null) {
            inorder(root.left, arr);
            arr.add(Long.valueOf(root.val));
            inorder(root.right, arr);
        }
    }

    public void swap(TreeNode root, Long first, Long second) {
        if (root != null) {
            swap(root.left, first, second);
            if (root.val == first)
                root.val = second.intValue();
            else if (root.val == second)
                root.val = first.intValue();
            swap(root.right, first, second);
        }
    }
}

// Time complexity : O(n) +O(n) + O(n)
// Space complexity : O(n)+ O(h)