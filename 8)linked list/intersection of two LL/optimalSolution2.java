
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2) {
            l1 = (l1 != null) ? l1 = l1.next : headB;
            l2 = (l2 != null) ? l2 = l2.next : headA;
        }
        return l1;
    }
}

// Time Complexity : O(2M) M: length of larger LL