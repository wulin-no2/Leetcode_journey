class MyStack {
    Queue<Integer> q = new LinkedList<>();
    public MyStack(){
        
    }
    public void push(int x){
        // everytime we push an element, move all the previous elements to the end of the element;
        q.offer(x);
        int i = q.size();
        while( i > 1){
            q.offer(q.poll());
            i--;
        }
        
    }
    public int pop(){
        return q.poll();
        
    }
    public int top(){
        return q.peek();
        
    }
    public boolean empty(){
        return q.isEmpty();
        
    }
    /*my solution before:
    // analyze:
    // use 2 queues;
    // when push(), q1.push();
    // when pop(), q2.push(q1.pop()) until q1.size = 1, then get q1.pop(); then push elements back to q1;
    // when top(), similar to pop();
    // when empty(), see if q1 is empty;
    // Java only has Deque() class, instead of Queue() class;
    Queue q1 = new LinkedList();
    Queue q2 = new LinkedList();
    
    public MyStack() {
        
    }
    
    public void push(int x) {
        q1.offer(x);
        
    }
    
    public int pop() {
        while(q1.size() > 1){
            q2.offer(q1.poll());
        }
        int res = (int)q1.poll();
        while(q2.size() > 0){
            q1.offer(q2.poll());
        }
        return res;    
    }
    
    public int top() {
        while(q1.size() > 1){
            q2.offer(q1.poll());
        }
        int res = (int)q1.peek();
        q2.offer(q1.poll());
        
        while(q2.size() > 0){
            q1.offer(q2.poll());
        }
        return res;   
    }
    
    public boolean empty() {
        return q1.isEmpty();
        
    }
    */
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */