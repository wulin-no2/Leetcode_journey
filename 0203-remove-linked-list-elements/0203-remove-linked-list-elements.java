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
    public ListNode removeElements(ListNode head, int val) {
        /* from solution;
        if (head == null) {
            return head;
        }
        // use a dummy head as the pre of the head;
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
        */
        // write on my own;
        if(head == null) return head;
        // use a dummy head as the pre of the head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        // use a pointer to traverse;
        ListNode cur = dummy; // since we need to delete the next node. so the first one should be dummy then we won't ignore head;
        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }
            else{
                cur = cur.next;
            }
        }
        return dummy.next;

    }
}