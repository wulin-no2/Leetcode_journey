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
    public ListNode detectCycle(ListNode head) {
        // if they met at temp, they joint at node
        // then from head to node equals to from temp to node;
        // find temp first;
        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;   
            if(fast == slow) {temp = fast; break;}
        }
        if(temp == null) return null;
        ListNode p = head;
        while(p != temp){
            p = p.next;
            temp = temp.next;
            //if(p == temp) return temp;
        }
        return temp;
    }
}