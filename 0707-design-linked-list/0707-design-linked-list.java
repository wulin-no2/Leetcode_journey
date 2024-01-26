class MyLinkedList {
    int val;
    int size = 0;
    Node dummyHead = new Node();
    
    public MyLinkedList() {
        dummyHead.next = dummyHead;
        dummyHead.pre = dummyHead;
    }
    
    public int get(int index) {
        if(index < 0 || index >= size) return -1;
        Node p = dummyHead;
        while(index-- >= 0){
            p = p.next; 
        }
        return p.val; 
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = dummyHead.next;
        node.pre = dummyHead;
        dummyHead.next.pre = node;
        dummyHead.next = node;
        size++;
    }
    
    public void addAtTail(int val) {
        Node node = new Node(val);
        node.next = dummyHead;
        node.pre = dummyHead.pre;
        dummyHead.pre.next = node;
        dummyHead.pre = node;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return; // Handle invalid index
        // !!! index can equal to size,just add to the last position;
        Node p = dummyHead;
        while(index-- >= 0){
            p = p.next; 
        }
        Node node = new Node(val);
        node.next = p;
        node.pre = p.pre;
        p.pre.next = node;
        p.pre = node;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return; // Handle invalid index
        Node p = dummyHead;
        while(index-- >= 0){
            p = p.next; 
        }
        p.pre.next = p.next;
        p.next.pre = p.pre;
        size--;
    }
    private class Node{
        int val;
        Node next /*= new Node()*/;
        Node pre /*= new Node()*/;
        public Node(){
        }
        public Node(int val){
            this.val = val;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */