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
        // we copy node and the val, and the next pointer and the random pointer
        // node and val and next is easy to copy, but what about random?
        // we know old node and new node and old.random, how to find new random?
        // we need to construct a data structure from each old to each new
        // so that when we find old.random, we will know new.random
        // from node to node, we use map
        Map<Node, Node> map = new HashMap<>();
        // we copy all the node and val first and next
        Node p1 = head;
        Node dummyHead = new Node(0);
        Node p2 = dummyHead;
        while(p1 != null){
            Node temp = new Node(p1.val); // copy node
            p2.next = temp; // connect last one
            map.put(p1, temp);// put into map
            p1 = p1.next; // move p1
            p2 = p2.next; // move p2
        }
        // now we got nodes and vals and nexts, we can copy randoms
        p1 = head;
        p2 = dummyHead.next;
        while(p1 != null){
            p2.random = map.get(p1.random);
            p1 = p1.next;
            p2 = p2.next;
        }
        return dummyHead.next;

        
    }
}