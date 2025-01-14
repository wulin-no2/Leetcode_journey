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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // use 2 pointers to traverse 2 lists
        // use another p to construct new list
        ListNode head = new ListNode(); // used to return new list
        ListNode p = head;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while(p1 != null && p2 != null){
            if(p1.val <= p2.val) {p.next = p1; p1 = p1.next;}
            else {p.next = p2; p2 = p2.next;}
            p = p.next;
        }
        while(p1 != null){
            p.next = p1;
            p1 = p1.next;
            p = p.next;
        }
        while(p2 != null){
            p.next = p2;
            p2 = p2.next;
            p = p.next;
        }
        return head.next;
        
    }
}