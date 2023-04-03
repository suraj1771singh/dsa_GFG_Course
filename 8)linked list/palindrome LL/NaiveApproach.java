//Naive approach
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        String s = new String();
        ListNode l1 = head;
        
        while (l1 != null) {
            s += String.valueOf(l1.val);
            l1 = l1.next;
        }

        // checking string is palindrome or not
        int n = s.length();
        int j = n - 1;
        int i = 0;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;

    }
}