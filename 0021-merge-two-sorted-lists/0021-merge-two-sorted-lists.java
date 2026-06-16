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
        // use two pointers
        // use a dummyhead
        ListNode dummyHead = new ListNode(-1000);
        ListNode p0 = dummyHead;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while(p1 != null && p2 != null){
            if(p1.val <= p2.val){
                p0.next = p1;
                p1 = p1.next;
            }
            else{
                p0.next = p2;
                p2 = p2.next;

            }
            p0 = p0.next;
        }
        while(p1 != null){
            p0.next = p1;
            p1 = p1.next;
            p0 = p0.next;
        }
        while(p2 != null){
            p0.next = p2;
            p2 = p2.next;
            p0 = p0.next;
        }
        return dummyHead.next;
        
    }
}