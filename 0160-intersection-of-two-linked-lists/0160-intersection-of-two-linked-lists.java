/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // approach 1: use 2 pointers and store nodes into hashset;
        // approach 2: find their length, then move the longer one first until they have same number of nodes remained. then move together until they equals
        ListNode p1 = headA;
        ListNode p2 = headB;
        int sizeA = 0;
        int sizeB = 0;
        while(p1 != null){
            p1 = p1.next;
            sizeA++;
        }
        while(p2 != null){
            p2 = p2.next;
            sizeB++;
        }
        if(sizeA > sizeB){
            int n = sizeA - sizeB;
            p1 = headA;
            while(n-- != 0){
                p1 = p1.next;
            }
            p2 = headB;
        }
        else{
            int n = sizeB - sizeA;
            p2 = headB;
            while(n-- != 0){
                p2 = p2.next;
            }
            p1 = headA;
        }
        while(p2 != null){
            if(p1 == p2) return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
        
    
}