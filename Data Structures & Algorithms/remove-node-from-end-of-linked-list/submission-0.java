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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode tmp = head;
        while(tmp!=null){
            size++;
            tmp = tmp.next;
        }

        int nodeToDeleteFromBeg = size-n +1;

        ListNode p1 = head;
         // If deleting first node
        if (nodeToDeleteFromBeg == 1) {
            return head.next;
        }
        for(int i=1;i<nodeToDeleteFromBeg-1;i++){
            p1 = p1.next;
        }
        p1.next = p1.next.next;
        return head;
    }
}
