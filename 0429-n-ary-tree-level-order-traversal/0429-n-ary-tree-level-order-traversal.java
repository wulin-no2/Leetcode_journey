/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        // level order
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Deque<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            while(size-- > 0){
                Node temp = q.poll();
                list.add(temp.val);
                for(Node node : temp.children){
                    if(node != null) q.offer(node);
                }
            }
            res.add(list);
        }
        return res;
    }
}