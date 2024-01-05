class MyQueue {
    // analyze:
    // how to make if FIFO?
    // use 2 stacks;
    // when push(), find the non empty one to push;
    // when pop(), pop() all the elements to the other one, and pop(), and pop() to the original one again;
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
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */