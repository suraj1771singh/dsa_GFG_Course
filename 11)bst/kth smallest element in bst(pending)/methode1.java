
//Definition for a binary tree node.
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 
class Solution {
    private int k=0;
    public int kthSmallest(TreeNode root, int count) {
        k=count;
        return f(root);
    }
    public int f(TreeNode root){
      if(root!=null){
        int l=f(root.left);
        if(l!=-1) return l;
        k--;
        if(k==0){
            return root.val;
        }
        int r=f(root.right);
        if(r!=-1) return r;
      }
      return -1;
    }
}

// Time complexity : O(n)
// ASS : O(h)