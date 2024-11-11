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
        if(head==null) return null;
        // 1. copy each node and their next;
        Node curr = head;
        while(curr != null){
            Node node = new Node(curr.val);
            node.next = curr.next;
            curr.next = node;
            curr = node.next;
        }
        // 2. copy their random (have to find each node and their copy easily, we can add their copy right after each node);
        curr = head;
        while(curr != null){
            if(curr.random==null) curr.next.random = null;
            else curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
            
        // 3. seperate them
        curr = head;
        Node copiedHead = head.next;
        Node p = copiedHead;
        while(curr != null){
            curr.next = curr.next.next;
            curr = curr.next;
            if(p.next != null){
                p.next = p.next.next;
                p = p.next;
            }
        }
        return copiedHead;
    }
}