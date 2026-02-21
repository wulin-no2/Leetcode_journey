class MinStack {
    // there should be a stack to implement the basic methods
    // but we also need to remember the min of stack no matter what state we're in 
    // so use another stack to track the min
    Deque<Integer> stack = new ArrayDeque();
    Deque<Integer> minStack = new ArrayDeque();
    public MinStack() {
    }
    
    public void push(int val) {
        if(minStack.isEmpty() || val <= minStack.peek()) minStack.push(val);
        stack.push(val);
    }
    
    public void pop() {
        int i = stack.pop();
        if(i == minStack.peek()) minStack.pop();
        
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
        return minStack.peek();
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */