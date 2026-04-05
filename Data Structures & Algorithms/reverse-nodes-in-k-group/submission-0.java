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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k==1){
            return head;
        }

        ListNode dmy = new ListNode(-1);
        dmy.next = head;

        ListNode beforeStart = dmy;
        ListNode e = head;

        int i=0;

        while(e!=null){
            i++;

            if(i%k==0){
                ListNode s = beforeStart.next;
                ListNode temp = e.next;

                reverse(s,e);

                beforeStart.next = e;
                s.next = temp;

                beforeStart = s;
                e=temp;
            }else{
                e=e.next;
            }
        }

        return dmy.next;
    }

    private void reverse(ListNode start,ListNode end){
        ListNode prev = null;
        ListNode cur = start;
        ListNode stop = end.next;

        while(cur!=stop){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
    }
}
