/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node curr = head;

        // 1. copy node and insert it into curr.next
        while(curr != null){
            Node node = new Node(curr.val);
            node.next = curr.next;
            curr.next = node;
            curr = node.next;
        }

        // copy random pointers;
        curr = head;
        while(curr != null){
            if(curr.random==null) curr.next.random = null;
            else curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        // separate them;
        curr = head;
        Node newHead = curr.next;
        Node p = newHead;
        while(curr != null){
            curr.next = curr.next.next;
            curr = curr.next;
            if(p.next != null){
                p.next = p.next.next;
                p = p.next;
            }
        }
        return newHead;

        
    }
}