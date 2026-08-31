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
        // we need a seperate flag to remember if we need to +1 to the next digit
        ListNode dummyHead = new ListNode(0);
        ListNode p0 = dummyHead;
        int complement = 0;
        while(l1 != null && l2 != null){
            int temp = (l1.val + l2.val + complement) % 10;
            complement = (l1.val + l2.val + complement) / 10;
            ListNode curr = new ListNode(temp); // create node
            p0.next = curr;// link to the last one
            p0 = curr; // move pointer
            l1 = l1.next;
            l2 = l2.next;//move 2 lists
        }
        while(l1 != null){
            int temp = (l1.val + complement) % 10;
            complement = (l1.val + complement) / 10;
            ListNode curr = new ListNode(temp); // create node
            p0.next = curr;// link to the last one
            p0 = curr; // move pointer
            l1 = l1.next; // move list
        }
        while(l2 != null){
            int temp = (l2.val + complement) % 10;
            complement = (l2.val + complement) / 10;
            ListNode curr = new ListNode(temp); // create node
            p0.next = curr;// link to the last one
            p0 = curr; // move pointer
            l2 = l2.next; // move list
        }
        if(complement == 1){
            ListNode curr = new ListNode(1);
            p0.next = curr;
        }
        return dummyHead.next;
        
        
    }
}