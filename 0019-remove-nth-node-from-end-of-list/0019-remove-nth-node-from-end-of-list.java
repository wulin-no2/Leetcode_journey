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
        // We might have to remove the head, so use a dummyHead
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        // find the previous node and then move the node
        // fast slow approach. 2 pointers
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;

        // fast go n steps in advance, then move slow.next;
        while(fast.next != null && n > 0){
            fast = fast.next;
            n--;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        // remove slow.next;
        slow.next = slow.next.next;
        return dummyHead.next;


        
    }
}