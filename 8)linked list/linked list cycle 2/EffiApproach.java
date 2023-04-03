//APPROACH

// -->take 2 ponters slow and fast
// -->slow move by 1 and fast move by 2
// -->if there is cycle they wil meet , if they meet then point fast pointer to head 
// -->keep moving both fast and slow pointer with same speed of 1
// -->return node when they meet
// -->else return null

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class EffiApproach {
    public ListNode detectCycle(ListNode head) {
        ListNode sp = head, fp = head;
        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
            if (sp == fp) {
                fp = head;
                while (fp != sp) {
                    sp = sp.next;
                    fp = fp.next;
                }
                return sp;
            }
        }
        return null;

    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)