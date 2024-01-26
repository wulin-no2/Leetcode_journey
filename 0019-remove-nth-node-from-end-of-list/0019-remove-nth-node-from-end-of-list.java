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
        // use fast slow approach; use dummyHead;
        // fast move n + 1, then slow move together until fast == nullw ;
        // delete slow.next;
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        n++;// don't forget it!!!
        while(n -- != 0 && fast != null){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        if(slow.next != null) slow.next = slow.next.next;
        return dummyHead.next;
    }
}