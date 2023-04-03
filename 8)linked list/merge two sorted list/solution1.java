//no extra space
class ListNode {
    int val;
    ListNode next;
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // l1 will always point out to smaller element LL
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        ListNode res = l1;
        while (l1 != null && l2 != null) {
            ListNode temp = null;
            while (l1 != null && l1.val <= l2.val) {
                temp = l1;
                l1 = l1.next;
            }
            temp.next = l2; // breaking and making link

            // swap
            ListNode node = l1;
            l1 = l2;
            l2 = node;
        }
        return res;
    }
}

// Time Complexity : O(n+m)
// space Complexity : O(1)