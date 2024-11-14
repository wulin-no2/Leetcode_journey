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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // use 2 pointers, update and return l1
        ListNode res = new ListNode();
        ListNode p = res;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        while(p1 != null && p2 != null){
            int sum = p1.val + p2.val + carry;
            p.val = sum % 10;
            carry = sum / 10;
            p1 = p1.next;
            p2 = p2.next;
            if(p1 != null || p2 != null || carry != 0) p.next = new ListNode();
            p = p.next;
        }
        while(p1 != null){
            int sum = carry + p1.val;
            p.val = sum % 10;
            carry = sum / 10;
            if(p1.next==null && carry==1) p1.next = new ListNode(0);
            p1 = p1.next;
            if(p1 != null || carry != 0) p.next = new ListNode();
            p = p.next;
        }
        while(p2 != null){
            int sum = carry + p2.val;
            if(p==null) p = new ListNode();
            p.val = sum % 10;
            carry = sum / 10;
            if(p2.next==null && carry==1) p2.next = new ListNode(0);
            p2 = p2.next;
            if(p2 != null || carry != 0) p.next = new ListNode();
            p = p.next;
        }
        if(carry == 1) p.val = 1;
        return res;
    }
}