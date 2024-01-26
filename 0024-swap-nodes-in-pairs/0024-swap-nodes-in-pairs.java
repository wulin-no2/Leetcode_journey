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
    public ListNode swapPairs(ListNode head) {
        // use dummyhead, use 2 temp Node to store nodes so that they can't be lost;
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while(cur.next != null && cur.next.next != null){
            // store 2 nodes;
            ListNode temp = cur.next;
            ListNode temp1 = cur.next.next.next;
            // swap them;
            cur.next = cur.next.next;
            cur.next.next = temp;
            temp.next = temp1;
            // don't forget to move cur;
            cur = cur.next.next;
        }  
        return dummyHead.next;
    }
}