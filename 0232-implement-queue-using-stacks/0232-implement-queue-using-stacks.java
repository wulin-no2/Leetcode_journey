class MyQueue {
    Deque<Integer> s1 = new LinkedList<>();
    Deque<Integer> s2 = new LinkedList<>();
    public MyQueue(){
        
    }
    public void push(int x){
        // always push to s1;
        s1.push(x);
    }
    public int pop(){
        // always pop() from s2 until it's empty; then pop all elements from s1 to s2 and pop();
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    public int peek(){
        // always peek()  from s2 until it's empty; then pop all elements from s1 to s2 and peek();
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    public boolean empty(){
        return s1.isEmpty() && s2.isEmpty();
        
    }
    /*mu solution before:
    // analyze:
    // how to make if FIFO?
    // use 2 stacks in which the second one is as an assistant;
    // when push(), find first one to push;
    // when pop(), pop() all the elements to the assistant and pop(), and pop() to the first one again;
    // when peek, similar to pop;
    // when empty(), the first stack should be empty;
    Stack stack;
    Stack stackA;
    

    public MyQueue() {
        stack = new Stack();
        stackA = new Stack();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        while(!stack.isEmpty()){
            stackA.push(stack.pop());
        }
        int res = (int)stackA.pop();
        while(!stackA.isEmpty()){
            stack.push(stackA.pop());
        }
        return res;
    }
    
    public int peek() {
        while(!stack.isEmpty()){
            stackA.push(stack.pop());
        }
        int res = (int)stackA.peek();
        while(!stackA.isEmpty()){
            stack.push(stackA.pop());
        }
        return res;
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
    */
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */