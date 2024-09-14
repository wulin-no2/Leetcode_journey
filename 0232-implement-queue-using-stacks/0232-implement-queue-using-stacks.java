class MyQueue {
    // we can implement a quque with 2 stacks;
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public MyQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        // push in in stack
        inStack.push(x);
    }
    
    public int pop() {
        // every time we have to pop:
        // 1) check out stack, if not null, pop;
        if(!outStack.isEmpty()){
            return outStack.pop();
        }
        // 2) if null, put all elements in stack into out stack, then pop;
        // if(inStack.isEmpty()) return null;
        while(! inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        return outStack.pop();
    }
    
    public int peek() {
        // pop from out stack, then put in out stack;
        // if(this.empty()) return null;
        int temp = this.pop();
        outStack.push(temp);
        return temp;

    }
    
    public boolean empty() {
        // if both in stack and out stack are empty;
        if(inStack.isEmpty() && outStack.isEmpty()) return true;
        return false;
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