
class ListNode {
    ListNode next;
    int value;
}

public class pointersApproach {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fp = head, sp = head;
        // fast pointer
        while (n != 0) {
            fp = fp.next;
            n--;
        }
        // edge case when we have to remove 1st node
        if (fp == null)
            return head.next;

        // moving fast as well as slow pointer
        while (fp.next != null) {
            sp = sp.next;
            fp = fp.next;
        }
        // execution from rigth to left
        sp.next = sp.next.next;
        return head;
    }

}
