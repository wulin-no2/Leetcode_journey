/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        // use map to store original node for us to clone so that we can't clone duplicatedly
        HashMap<Node, Node> map = new HashMap<>();
        // use BFS to traverse and clone
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        
        //put node into map
        map.put(node, new Node(node.val));
        
        // traverse
        while(! q.isEmpty()){
            // get a node
            Node temp = q.poll();
            // process all the neighbours
            for(Node neighbor: temp.neighbors){
                if(!map.containsKey(neighbor)){
                        // if not cloned, clone it
                        map.put(neighbor, new Node(neighbor.val));
                        // add it to the queue
                        q.offer(neighbor);
                }
                // add cloned neighbor to the current node's cloned version
                map.get(temp).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);

    }
    
}