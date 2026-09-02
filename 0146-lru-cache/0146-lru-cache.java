class LRUCache {
    int capacity;
    Node tail;
    Node head;
    Map<Integer, Node> map = new HashMap<>();
    // 1. in order to  get a value by a key in O(1),  we need a map
    // 2. in order to add and remove at any place in O(1), and keep an order, we need a linkedlist
    // 3. we need a double linkedlist so that we can find the prev and point to the next
    // 4. in the map, we put<key, <Node>> in it
    // 5. in Node, we put prev, next, key, value in it so that when we delete the node from map, we can find it by key

    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail = new Node();
        head = new Node();
        head.next = tail;
        tail.prev = head; // we put the latest updated before tail
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        //1. get value by key in map
        Node curr = map.get(key);
        //2. remove the last one, add the latest one
        removeNode(curr);
        addToLast(curr);
        return curr.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            removeNode(curr);
            curr.value = value;
            addToLast(curr);
        } else if(map.size() < this.capacity){
            Node temp = new Node(key, value);
            addToLast(temp);
        } else{
            removeNode(head.next);
            Node temp = new Node(key, value);
            addToLast(temp);
        }
    }
    
    private void removeNode(Node node){
        // remove from list
        Node temp = node.next;
        node.prev.next = temp;
        temp.prev = node.prev;
        // remove from map
        map.remove(node.key);
    }

    private void addToLast(Node node){
        //add to list
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        //add to map
        map.put(node.key, node);
    }
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(){

        }
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
        public Node(int key, int value, Node prev, Node next){
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */