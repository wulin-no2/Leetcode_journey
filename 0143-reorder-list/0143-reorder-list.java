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
        if (head == null || head.next == null) return;
        // reverse the 2nd half. How to find the 2nd half?
        // use a fast slow approach, speed2, speed1
        // when fast is at the end, the slow should be at the 2nd half;
        // but we have to find the one before 2nd half so we can cut it up!!!
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow is in the middle(left one for double nodes) or middle for odd nodes
        // cut it up!!!
        ListNode list2 = slow.next;
        slow.next = null;
        // then reverse the second half from slow list2
        // we need prev curr to reverse it
        ListNode prev = null;
        ListNode curr = list2;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        } // now prev is the start of the 2nd list
        // head is the start of the 1nd list
        // then merge two lists together // head and prev
        ListNode list1 = head;
        list2 = prev;
        while(list2 != null){
            ListNode temp1 = list1.next;
            ListNode temp2 = list2.next;  // same the remaining lists
            list1.next = list2;
            list2.next = temp1; // add two nodes 
            list1 = temp1;
            list2 = temp2; // start to work on the 2nd round
        }
    }
}