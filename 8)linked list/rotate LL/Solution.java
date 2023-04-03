//Naive Approach

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode h1 = head;
        int count = 0;
        while (h1 != null) {
            h1 = h1.next;
            count++;
        }

        k = k % count;
        while (k != 0) {
            h1 = head;
            while (h1.next.next != null) {
                h1 = h1.next;
            }
            ListNode tail = h1;
            ListNode temp = tail.next;
            temp.next = head;
            head = temp;
            tail.next = null;
            k--;
        }
        return head;
    }

}

// Time Complexity : O( (k%n) * n ) : n is the length of linked list
// Space Complexity : O(1)
