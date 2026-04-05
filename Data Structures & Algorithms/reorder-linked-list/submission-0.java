/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    ListNode temp = null;
    public void reorderList(ListNode head) {
      
        if (head == null || head.next == null) return;

        // 1️⃣ Count length
        ListNode tmp = head;
        int n = 0;
        while (tmp != null) {
            n++;
            tmp = tmp.next;
        }

        // 2️⃣ Move to middle
        int mid = (n + 1) / 2;
ListNode l1 = head;
for (int i = 1; i < mid; i++) {
    l1 = l1.next;
}

        ListNode l2 = l1.next;
        l1.next = null;   // split list

        // 3️⃣ Reverse second half (in-place)
        l2 = reverseList(l2);

        // 4️⃣ Merge alternately
        l1 = head;

        while (l1 != null && l2 != null) {

            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;

            l1.next = l2;
            l2.next = l1Next;

            l1 = l1Next;
            l2 = l2Next;
        }
        
    }

    
 // Proper reverse (NO new nodes created)
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
