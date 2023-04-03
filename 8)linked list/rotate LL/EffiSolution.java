//ALGO 

//-->take two pointer h1 and h2 and point them to head
//-->move h2 ahead till k is not zero and keep h1 at head
//-->then move h1 and h2 together while h2!=null
//-->make  following steps
// temp=h1.next
// h1.next=null
// h2.next=head;
// head= temp;

public class EffiSolution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode h1 = head, h2 = head;

        int count = 0;
        // count size of LL
        while (h1 != null) {
            count++;
            h1 = h1.next;
        }
        h1 = head;
        k = k % count;
        // base case
        if (k == 0 || k == count)
            return head;

        while (k != 0) {
            h2 = h2.next;
            k--;
        }
        // h2 is k steps ahead now
        while (h2.next != null) {
            h1 = h1.next;
            h2 = h2.next;
        }
        // now perfom operations to delink and link linked list
        ListNode temp = h1.next;
        h1.next = null;
        h2.next = head;
        head = temp;
        return head;
    }
}
// Time Complexity : O(n)
// Space Complexity : O(1)