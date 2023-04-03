
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class NaiveApproach {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        int flag = 0;
        while (l1 != null) {
            l2=headB;
            while (l2 != null) {
                if (l1 == l2) {
                    flag = 1;
                    break;

                }
                l2 = l2.next;
            }
            if (flag == 1)
                break;
            l1 = l1.next;
        }
        return l1;

    }
}
// Time Complexity : O(M*N)