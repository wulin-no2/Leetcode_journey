class MinStack {
    // use 2 stacks, one for storing all elements, one for tracking min elements
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> mins = new ArrayDeque<>();
    

    public MinStack() {
        
    }
    
    public void push(int val) {
        if(mins.isEmpty() || val <= getMin()) mins.push(val);
        stack.push(val);
    }
    
    public void pop() {
        if(stack.peek().equals(mins.peek())) mins.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mins.peek();
        
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