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
        // bfs
        // use a queue 
        if(node == null) return null;
        // use a map to store origin and cloned node, in case we clone duplicated nodes
        Map<Node, Node> map = new HashMap<>(); 
        Deque<Node> q = new LinkedList<>();
        // clone the first node and put it in the queue and map
        Node newNode = new Node(node.val);
        map.put(node, newNode); 
        q.offer(node);
        while(! q.isEmpty()){
            Node temp = q.poll();
            List<Node> neighbors = temp.neighbors;
            for(Node neighbor : neighbors){
                if(! map.containsKey(neighbor)){
                    Node cloned = new Node(neighbor.val);
                    map.put(neighbor, cloned);
                    q.offer(neighbor); // why???
                }
                // add the cloned neighbor to the cloned node's neighbor list
                map.get(temp).neighbors.add(map.get(neighbor));
            }

        }
        return newNode;

        
    }
}