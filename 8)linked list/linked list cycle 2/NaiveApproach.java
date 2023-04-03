import java.util.HashMap;

// using hash table
// keep track of every node and when u find first repeating node return it
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode detectCycle(ListNode head) {

        HashMap<ListNode, Boolean> map = new HashMap<>();
        ListNode h1 = head;
        while (h1 != null) {
            if (map.containsKey(h1)) {
                return h1;
            }
            map.put(h1, true);
            h1 = h1.next;
        }
        return null;
    }
}

// Time Complexity : O(n)
// space Complexity : O(n)