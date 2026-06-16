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
        // we have to find the node before this node to remove it
        // use 2 fast slow pointers, fast move n + 1 steps first
        // then slow.next would be our aim when fast is null
        // we might remove the head if only one node and n is 1, so use a dummyHead
        
        ListNode dummyHead = new ListNode(0, head);
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;       

        // move fast first     
        // n might be bigger than the length of list
        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }
        // move them together
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        // remove the node;
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}