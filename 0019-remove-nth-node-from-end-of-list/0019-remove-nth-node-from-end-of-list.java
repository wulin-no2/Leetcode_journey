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
        // fast slow approach to find the previous node of the nth node;
        // fast moves n + 1, slow starts to move;
        // slow point to next.next;
        // to prevent the head removed, use dummyHead;
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        while(n + 1 > 0 && fast != null){
            fast = fast.next;
            n--;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
    
}