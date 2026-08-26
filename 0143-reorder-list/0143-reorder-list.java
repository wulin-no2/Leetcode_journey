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
    public void reorderList(ListNode head) {
        // if we want to reorder, then we have to know both ends
        // also, we have to break it into 2 parts otherwise we'll have a loop at the end
        // for the first half, we keep it as it is
        // for the second half, we reverse it
        // so, 1. we do fast slow approach, find the mid point
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode list2 = slow.next;
        // 2. break it
        slow.next = null;
        // 3. reverse the 2nd half
        ListNode prev = null;
        ListNode curr = list2;
        while(curr != null){
            ListNode temp = curr.next; // store the remaining
            curr.next = prev; // reverse
            prev = curr;
            curr = temp;
        }
        // prev is the reversed 2nd list now
        // 4. merge them: head and prev
        ListNode p = new ListNode(0);
        ListNode p1 = head;
        ListNode p2 = prev;
        while(p1 != null && p2 != null){
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;
            p.next = p1;
            p.next.next = p2;
            p1 = temp1;
            p2 = temp2;
            p = p.next.next;
        }
        if(p1 != null){
            p.next = p1;
        }
    }
}