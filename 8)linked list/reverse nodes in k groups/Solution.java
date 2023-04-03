class ListNode {
    int val;
    ListNode next;
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0, flag = 1;
        ListNode h1 = head;
        while (h1 != null) {
            count += 1;
            h1 = h1.next;
        }
        count = count / k;
        ListNode curr = head, connector, prevHead = head;

        while (count != 0) {
            int i = k;
            connector = prevHead;
            prevHead = curr;
            ListNode prev = null;
            while (i != 0) {
                ListNode temp;
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
                i--;
            }
            if (flag == 1) {
                head = prev;
                flag = 0;
            } else
                connector.next = prev;
            prevHead.next = curr;
            count--;

        }
        return head;
    }
}