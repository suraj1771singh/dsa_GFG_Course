
//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

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

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.val);
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode prev = head;
        while (p2 != null && p2.next != null) {
            p2 = p2.next.next;
            prev = p1;
            p1 = p1.next;
        }
        prev.next = null;
        TreeNode root = new TreeNode(p1.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(p1.next);
        return root;
    }

}