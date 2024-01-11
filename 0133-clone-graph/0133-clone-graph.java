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
        // graph search. we can BFS and DFS.
        // since it has on direction. we have to record the node we've visited.
        // try BFS with queue. 
        // mark the node we visited as value = -1;
        // get one node from queue: [record] it's neighbors / create List<node> with values, set visited; for each neighbors: if it's not visited, push into queue; 
        // how to record its visited? use another int[100], if its visited set int[i] = 1;
        
        if(node == null) return null;
        Map<Node, Node> clonedMap = new HashMap<>();
        
        Node copy = new Node();
        if(node.neighbors == null) {
            copy.val = 1;
            copy.neighbors = null;
            return copy;
        }
        // if node has neighbors:
        Queue<Node> q = new LinkedList<>(); // used for storing nodes for further processing;
        int[] arr = new int[101];
        q.offer(node);
        arr[1] = 1;
        // add following 2 lines from GPT:

        clonedMap.put(node, new Node(node.val, new ArrayList<>()));
        
        while(! q.isEmpty()){
            Node p = q.poll();
            // Node curNew = q.poll(); 
            // create list for each node;
            // List<Node> pL = new ArrayList<>();
            for(Node n : p.neighbors){
                // Node m = new Node();
                // m.val = n.val;
                // pL.add(m);
                clonedMap.putIfAbsent(n, new Node(n.val, new ArrayList<>()));
                // populate list with n;
                clonedMap.get(p).neighbors.add(clonedMap.get(n));
                if(arr[n.val] != 1) {
                    q.offer(n);
                    arr[n.val] = 1;
            }
            // curNew.val = p.val;
            // curNew.neighbors = pL;
            // arr[p.val] = 1;
            // if(curNew.val == 1) copy = curNew;
        }
        }
        return clonedMap.get(node);
    }
}