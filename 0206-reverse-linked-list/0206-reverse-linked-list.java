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
        // we use 2 pointers pre, curr to change direction
        // use a temp to store the following node
        // until curr is null
        ListNode curr = head;
        ListNode pre = null;
        ListNode temp = null;
        while(curr!=null){
            // store following list;
            temp = curr.next;
            // change direction;
            curr.next = pre;
            // move pointers;
            pre = curr;
            curr = temp;
        }
        return pre;
        
        
    }
}