/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 0 node:
        if(head == null){return false;}
        // n nodes:
        ListNode slow = head;
        ListNode fast = head;

        //int pos = -1;
/*        int index1 = 0;//the position of temp1;     
        while(temp1.next != null){
            for(int n = 0 ; n <= index1 ; n ++){
                if(temp1.next == temp2){
                    //pos = n;
                    return true;
                }else{
                    temp2 = temp2.next;
                }
            }
            index1++;
            temp1 = temp1.next;
        }*/
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }


}