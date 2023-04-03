class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class optimApproach {
    public boolean isPalindrome(ListNode head) {
        // finding middle node
        ListNode fp = head;
        ListNode sp = head;
        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }

        // move sp to right half
        if (fp != null)
            sp = sp.next;
        // reverse right half
        sp = reverse(sp);

        fp = head; // fp will point to head
        // now move together and compare
        while (sp != null) {
            if (sp.val != fp.val)
                return false;
            sp = sp.next;
            fp = fp.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
