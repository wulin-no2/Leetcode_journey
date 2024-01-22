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
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        // use a stack.
        Deque<ListNode> stack = new LinkedList<>();
        // stack.push(head);
        ListNode p = head;
        while(p != null){
            stack.push(p);
            p = p.next;
        }
        ListNode newHead = new ListNode(0);
        p = newHead;
        while(!stack.isEmpty()){
            p.next = stack.pop();
            p = p.next;
        }
        p.next = null;// why??
        return newHead.next;
    }
}



// class Solution {
//     public ListNode reverseList(ListNode head) {
//         // /*
//         if(head == null || head.next == null){return head;}
//         //new stack:
//         Stack<ListNode> s = new Stack<>();
//         //push Node into the stack;
//         ListNode p = head;
//         while(p != null){
//             s.push(p);
//             p = p.next;
//         }
//         // get a new head of the reversed List;
//         ListNode newHead = s.pop();
//         // the reversed List should be a ListNode;
//         ListNode lp = newHead;
        
//         // pop the elements from the stack:
//         while(!s.isEmpty()){
//             lp.next = s.pop();
//             lp = lp.next;
//         }
//         // set the last node to null:
//         lp.next = null;
//         return newHead;
//         // */
        
        
//     /*
//         //new LinkedList;
//         LinkedList<ListNode> l = new LinkedList<>();
//         //new stack:
//         Stack<ListNode> s = new Stack<>();
//         // new pointer:
//         ListNode p = head;
//         s.push(p);
//         //push every p.next into the stack untill p.next == null:
//         while(p.next != null){
//             s.push(p.next);
//             p = p.next;
//         }
//         // pop the elements from the stack:
//         while(!s.isEmpty()){
//             l.add(s.pop());
//         }
//         return l.get(0);  
//         */
        
//     }
// }