
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class optimalSolution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        int a = 0, b = 0;
        // calculating length of both LL simultaneusly
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                a++;
                l1 = l1.next;
            }
            if (l2 != null) {
                b++;
                l2 = l2.next;
            }
        }
        int count = Math.abs(a - b);

        if (a > b) {
            l1 = headA;
            l2 = headB;
        } else {
            l1 = headB;
            l2 = headA;
        }

        // putting larger length of LL ahead by count from it's head
        while (count != 0) {
            l1 = l1.next;
            count--;
        }
        // moving both l1 and l2 together
        while (l1 != l2) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;
    }
}

// Time Complexity : O(2M) M : length of larger length