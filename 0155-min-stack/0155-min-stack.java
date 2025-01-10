class MinStack {
    // use a data structure to track min value;
    // each step, only store the min value into the data structure;
    // use another stack to track it;
    Deque<Integer> stack = new LinkedList<>();
    Deque<Integer> minStack = new LinkedList<>();
    public MinStack() {
    }
    
    public void push(int val) {
        if(stack.isEmpty() || minStack.peek() >= val) minStack.push(val);
        stack.push(val);
    }
    
    public void pop() {
        if(stack.peek().equals(minStack.peek())) minStack.pop();
        stack.pop();
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