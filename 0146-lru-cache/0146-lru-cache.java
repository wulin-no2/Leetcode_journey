/*class LRUCache {

    // one solution from discuss:
    
    Node head = new Node(0, 0), tail = new Node(0, 0);
    Map<Integer, Node> map = new HashMap();
    int capacity;

    public LRUCache(int _capacity) {
        capacity = _capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
          Node node = map.get(key);
          remove(node);
          insert(node);
          return node.value;
        } else {
          return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
          remove(map.get(key));
        }
        if(map.size() == capacity) {
          remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node){
        map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }

    class Node{
        Node prev, next;
        int key, value;
        Node(int _key, int _value) {
          key = _key;
          value = _value;
        }
    }
    }
    */
    
/*
    class Node{//节点[pre|key|value|next]
    int key,val;
    Node next,pre;
    public Node(int key,int val){
        this.key = key;
        this.val = val;
    }
}
class DoubleList{//双链表head<->[key,val]<->tail
    Node head;//头结点
    Node tail;//尾结点
    public DoubleList(){
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.pre = head;
    }
    void addFirst(Node n){//头插
        head.next.pre = n;
        n.next = head.next;
        n.pre = head;
        head.next = n;
    }
    void remove(Node n){//删除指定节点n
        n.pre.next = n.next;
        n.next.pre = n.pre;
    }
    Node removeLast(){//删除尾结点，并返回该节点
        Node res = tail.pre;
        remove(res);
        return res;
    }
}
class LRUCache {
    HashMap<Integer,Node> map;
    DoubleList cache;
    int cap;//容量
    public LRUCache(int capacity) {
        map = new HashMap<>();
        cache = new DoubleList();
        this.cap = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))//若该节点不存在
            return -1;
        Node res = map.get(key);
        cache.remove(res);
        cache.addFirst(res);
        return res.val;
    }
    
    public void put(int key, int value) {
        Node n = new Node(key,value);
        if(map.containsKey(key)){//若该节点已经存在
            cache.remove(map.get(key));
        }else if(map.size()==cap){//若该节点不存在，但是cache已满
            Node last = cache.removeLast();
            map.remove(last.key);
        }
        cache.addFirst(n);
        map.put(key,n);
    }
}
 //*/ 
       

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class LRUCache {
    // analyze:
    //  1) use the linkedlist; put node into the list;
    // 2) in the node, we have key && value in the node;
    // 3) use hashmap to store key value so that we can get and put key and value in O(1) time;
    Map<Integer, Node> map = new HashMap<>();
    // List<Node> list = new LinkedList<>();
    int capacity = 0;
    Node head;
    Node tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        // get the value & remove the node,and add to the last;
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(key);
            add(key, node._value);
            return node._value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // see if exist; if exist, remove the node, and update value to the last;
        // if not exist, if full, remove the first, add to the last;
        // if not exist, if not full, add to the last, capacity++;
        if(map.containsKey(key)){
            remove(key);
        }
        if(capacity == map.size()){
            remove(head.next._key);
        }
        add(key, value);
    }
    // remove node
    public void remove(int key){
        // find from map;
        // remove from map and list;
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;
            map.remove(key);
        }
    }
    
    // addLast node. it's not full;
    public void add(int key, int value){
        Node node = new Node(key, value);
        node.next = tail;
        node.pre = tail.pre;
        tail.pre.next = node;
        tail.pre = node;
        map.put(key, node);
    }
    // the LinkedList should be double ended;
    class Node{
        int _key;
        int _value;
        Node pre;
        Node next;
        
        public Node(int key, int value){
            this._key = key;
            this._value = value;
        }
    }
}
