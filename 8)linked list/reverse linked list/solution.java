class ListNode {
    int value;
    ListNode next;
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newhead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newhead;
            newhead = head;
            head = next;
        }
        return newhead;

    }
}
// Time complexity : O(n)
