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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // recursive solution:
        /*if(l1 == null){return l2;};
        if(l2 == null){return l1;};
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }*/
        
        // iterative solution:
        ListNode ans = new ListNode();
        ListNode ptr = ans;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                ans.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                ans.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            ans = ans.next;
        }
        while(l1 != null){
            ans.next = new ListNode(l1.val);
            l1 = l1.next;
            ans = ans.next;
        }
        while(l2 != null){
            ans.next = new ListNode(l2.val);
            l2 = l2.next;
            ans = ans.next;
        }
        return ptr.next;
        
    }
}