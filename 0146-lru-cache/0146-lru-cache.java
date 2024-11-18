class LRUCache {
    // 1. key-value pair, use map to store it; so we can get by key within O(1) and change the value within O(1)
    // 2. how to keep the order so that we can find the least recently used key && delete it in a place and put it in another place withinO(1)? LinkedList
    // 3. in order to delete the node and keep the order, we have to find the prev node. We could use double LinkedList
    // 4. we have to insert a node in the first, and delete the node in the last, so better use dummyHead and dummyTail to make things easier;
    class Node{
        int val = 0;
        int key = 0;
        Node next = null;
        Node prev = null;
        public Node(){};
        public Node(int key,int val){
            this.val = val;
            this.key = key;
        };
    }
    int capacity = 0;
    Map<Integer, Node> map = new HashMap<>();
    Node dummyHead = new Node(0,0);
    Node dummyTail = new Node(0,0);

    public LRUCache(int capacity) {
        this.capacity = capacity;

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;

    }
    
    public int get(int key) {
        //1. if not exist, return -1;
        if(! map.containsKey(key)) return -1;
        //2. if exist, 2.1. change list: delete it, add to the first, then return value; 
        Node node = map.get(key);
        delete(node);
        addFirst(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        //1. if exist: 1.1. get from map, change it's value; 1.2. change list: delete it, add to the first; 
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            delete(node);
            addFirst(node);
        }
        // 2. if not exist:
        else{
             
        // 2.1. if not full: put into map; add to the first of list;
        // 2.2. if full: delete the last of list && delete from map; put into first of the list; put into map;
            if(map.size() == capacity) {
                Node nodeRemove = dummyTail.prev;
                delete(nodeRemove);
                map.remove(nodeRemove.key);
            }
            
            Node temp = new Node(key, value);
            addFirst(temp);
            map.put(key, temp);
        }
    }
    public void delete(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
    }
    public void addFirst(Node node){
        node.next = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next.prev = node;
        dummyHead.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */