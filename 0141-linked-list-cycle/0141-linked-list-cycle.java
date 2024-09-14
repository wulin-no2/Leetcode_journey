/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // fast slow approach;
        // if there is a cycle, they must meet each other;
        ListNode fast = head;
        ListNode slow = head;
        if(fast==null) return false;
        while(fast != null){
            if(fast.next==null || fast.next.next==null) return false;
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
}