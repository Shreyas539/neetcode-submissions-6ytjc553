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
    ListNode finListPtr = null;     
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }

        while(head!=null){
            addFirst(head.val);
            head=head.next;
        }

        return finListPtr;
    }

    private void addFirst(int val){

        ListNode tempNode = new ListNode(val);
        tempNode.next = finListPtr;
        finListPtr=tempNode;
    }
}
