class MinStack {
    // use 2 stacks
    // one for maintain the minimum element
    // one for maintain the main stack
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> minStack = new ArrayDeque<>();
    public MinStack() {
    }
    
    public void push(int val) {
        // if val <= min, push into both stacks
        // if val > min, only push into main stack
        if(stack.isEmpty() || val <= minStack.peek()) minStack.push(val);
        stack.push(val);
    }
    
    public void pop() {
        // if top() > min, only pop() main stack
        // if top() == min, pop() both
        if(this.top() == this.getMin()) minStack.pop();
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