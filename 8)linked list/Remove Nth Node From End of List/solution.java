
class ListNode {
    ListNode next;
    int value;
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // traverse through LL and find size
        int count = 1;
        ListNode temp = head.next;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        count = count - n;
        // edge case when count=0
        if (count == 0) {
            temp = head;
            head = head.next;
            return head;
        }

        temp = head;
        ListNode node = head;
        while (count != 1) {
            count--;
            node = temp.next;
            temp = node;

        }
        temp = node.next;
        node.next = temp.next;
        return head;
    }
}