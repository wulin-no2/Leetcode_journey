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
        // 2 pointers. one list one pointers. compare and choose the smaller one and put it in the new list;
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode result = new ListNode();
        ListNode temp = result;
        while(p1 != null && p2 != null){
            if(p1.val>p2.val){
                temp.next = p2;
                temp = temp.next;
                p2 = p2.next;
            }
            else{
                temp.next = p1;
                temp = temp.next;
                p1 = p1.next;
            }
        }
        // now only one non-empty list is remained:
        while(p1 != null){
            temp.next = p1;
            temp = temp.next;
            p1 = p1.next;
            
        }
        while(p2 != null){
            temp.next = p2;
            temp = temp.next;
            p2 = p2.next;
        }
        return result.next;
    }
}