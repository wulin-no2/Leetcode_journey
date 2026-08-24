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
        // use p1 p2 to move our path
        // if p1.value <= p2.value, add p1 and move p1; the same for p2
        // when p1 or p2 is null, add the other one at the end of the list
        // return the head.next;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                curr.next = list1;
                curr = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                curr = list2;
                list2 = list2.next;
            }
        }
        if(list1 != null) curr.next = list1;
        if(list2 != null) curr.next = list2;
        return head.next;
    }
}