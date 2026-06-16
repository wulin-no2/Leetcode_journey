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
        // use the dummyHead so we don't have to check whether list1 or list2 should be the head
        ListNode dummyHead = new ListNode();
        // use a pointer to traverse
        ListNode p0 = dummyHead;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                p0.next = list1;
                list1 = list1.next;
            } else {
                p0.next = list2;
                list2 = list2.next;

            }
            p0 = p0.next;
        } 
        if(list1 != null){
            p0.next = list1;
        }
        if(list2 != null){
            p0.next = list2;
        }
        return dummyHead.next;
        
    }
}