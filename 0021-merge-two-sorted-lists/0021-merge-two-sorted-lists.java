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
        // analyze:
        // use 2 pointers and find the smaller one as the next node of the new List;
        // use the 3rd pointer to add nodes to the new List;
        // if(list1 == null){
        //     return list2;
        // }
        // if(list2 == null){
        //     return list1;
        // }
//         ListNode p1 = new ListNode();
//         ListNode p2 = new ListNode();
//         ListNode p3;
//         ListNode result = null;
        
//         p1.next = list1;
//         p2.next = list2;
//         p3 = result;
//         while(p1.next != null && p2.next != null){
//             if(p1.next.val > p1.next.val){
//                 result = p1.next;
//                 p1.next = p1.next.next;
//                 p3 = p3.next;
                
//             }else{
//                 result = p2.next;
//                 p2.next = p2.next.next;
//                 p3 = p3.next;
//             }
//         }
//         while(p1.next != null){
//             p3.next = p1.next;
//             p1.next = p1.next.next;
//         }
//         while(p2.next != null){
//             p3.next = p2.next;
//             p2.next = p2.next.next;
//         }
//         return result;
        
        // the problem is, I don't know how to add node to the end of the LinkedList; I need to use the third pointer to find the end of the linked list;
        // Or I can also use a stack;
        
        ListNode preHead = new ListNode(0);
    ListNode last = preHead;
    
    while(l1 != null && l2 != null) {
        if(l1.val > l2.val) {
            last.next = l2;
            l2 = l2.next;
        } else {
            last.next = l1;
            l1 = l1.next;
        }
        last = last.next;
    }
    
    if(l1 == null) {
        last.next = l2;
    } else {
        last.next = l1;
    }
    
    return preHead.next;
        
        
    }
}