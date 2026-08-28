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
        // use 2 pointers to find the nth one - 1
        // fast move n + 1 steps first so slow is the right one we want
        // we need a dummyHead in case we want to move the first one
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        while(fast != null && n >= 0){
            fast = fast.next;
            n--;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode temp = slow.next.next;
        slow.next = temp;
        return dummyHead.next;
    }
}