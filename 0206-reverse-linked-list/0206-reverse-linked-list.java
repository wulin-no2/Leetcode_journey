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
        // use 2 pointers to help update list
        ListNode prev = null;
        ListNode curr = head;
        // check if we've handled all the nodes
        while(curr != null){
            // handle current node
            // save the remaining first in case it's lost
            ListNode temp = curr.next;
            // reverse
            curr.next = prev;
            // move pointers
            prev = curr;
            curr = temp; // 1. curr should point to the remaining list
        }
        return prev; //1. now curr == null, prev is the link that's already handled
        
    }
}