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
    public ListNode middleNode(ListNode head) {
        // analyze:
        // traverse twice:
        // 1. traverse and use an int count to count the nodes;
        // 2. traverse and decrement the count until find the middle node;
        // use a pointer to traverse;
        
        int count = 1;
        ListNode ptr = head;
        
        // first traverse, get the count;
        while(ptr.next != null){
            ptr = ptr.next;
            count++;
        }
        // second traverse, find the middle;
        int mid = count / 2; 
        ptr = head;
        while(mid > 0){
            ptr = ptr.next;
            mid--;
        }
        return ptr;
    }
}