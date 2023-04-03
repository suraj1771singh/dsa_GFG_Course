//fast and slow pointers approach
class ListNode {
    int value;
    ListNode next;
}

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fp = head, sp = head;
        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }
        return sp;
    }
}
// Time Complexity : O(n/2)