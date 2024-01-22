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
// second round in 1.22.2024
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = new ListNode(0);
        // 2 pointers;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p3 = head;
        while(p1 != null && p2 != null){
            if(p1.val <= p2.val){
                p3.next = p1;
                p1 = p1.next;
            }
            else{
                p3.next = p2;
                p2 = p2.next;
            }
            p3 = p3.next;
        }
        while(p1 != null){
            p3.next = p1;
            p1 = p1.next;
            p3 = p3.next;
        }
        while(p2 != null){
            p3.next = p2;
            p2 = p2.next;
            p3 = p3.next;
        }
        return head.next; 
    }
}
        
        
/*      
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
        
        /*
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
*/