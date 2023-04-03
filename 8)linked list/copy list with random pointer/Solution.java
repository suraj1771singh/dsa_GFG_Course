
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        Node h1 = head;
        Node dummy = new Node(0);
        // creating copy of nodes and storing values
        while (h1 != null) {
            Node temp = new Node(h1.val);
            temp.next = h1.next;
            h1.next = temp;
            h1 = h1.next.next;
        }

        // creating copy of random pointer
        h1 = head;
        while (h1 != null) {
            if (h1.random != null)
                h1.next.random = h1.random.next;
            else
                h1.next.random = h1.random;
            h1 = h1.next.next;
        }

        // delinking copy from origin
        h1 = head;
        dummy.next = head;
        Node clonehead = dummy;
        while (h1 != null) {
            dummy.next = h1.next;
            h1.next = dummy.next.next;
            h1 = h1.next;
            dummy = dummy.next;
        }
        return clonehead.next;

    }

}
// Time Complexity : O(3*n)
// Time Space : O(1) apart from cloned linked list