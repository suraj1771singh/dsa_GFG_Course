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

// ------------METHODE 1 :
// 1) Inorder traversal , store element in array
// 2) use two pointer approach , the find there exist such pair or not

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        // two pointer approach
        int i = 0;
        int j = arr.size() - 1;
        while (i < j) {
            if ((arr.get(i) + arr.get(j)) > k)
                j--;
            else if ((arr.get(i) + arr.get(j)) < k)
                i++;
            else
                return true;
        }
        return false;

    }

    public void inorder(TreeNode root, List<Integer> arr) {
        if (root != null) {
            inorder(root.left, arr);
            arr.add(root.val);
            inorder(root.right, arr);
        }
    }
}