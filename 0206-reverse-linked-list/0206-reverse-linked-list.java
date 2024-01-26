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
    public ListNode reverseList(ListNode head) {
        // for each node cur: cur.next = pre;
        // until cur == null;
        // return pre;
        if(head == null) return head;
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
        /*
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next; // store the next node
            current.next = prev; // reverse the link
            prev = current; // move prev to current
            current = nextTemp; // move to next node
        }
        return prev; // prev will be the new head
        */
    }
}
 
        
