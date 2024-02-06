/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        // level order:
        if(root == null) return null;
        Deque<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                Node temp = q.poll();
                Node temp1 = q.peek();
                if(size != 0) temp.next = temp1;
                if(temp.left != null) q.offer(temp.left); 
                if(temp.right != null) q.offer(temp.right); 
            }
        }
        return root;
        
    }
}