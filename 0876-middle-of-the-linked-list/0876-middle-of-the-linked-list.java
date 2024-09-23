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
    public ListNode middleNode(ListNode head) {
        // fast slow approach
        // fast pointer fun faster 2 steps; slow pointer run slower 1 step;
        // when fast == null or fast.next == null return slow
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null){
            if(fast.next == null) break;
            fast = fast.next.next; // 3,5, null
            slow = slow.next; // 2,3,4
        }
        return slow;
        
    }
}