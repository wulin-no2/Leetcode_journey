class MinStack {
    // analyze:
    // use a variable of the class, each time we pop or push an elment, update the mininum;
    // the problem is,min value might duplicate. So we need to get the count of each value;
    // use array to store the counts of each count?No!!
    // use hashMap;??
    // no!! we can still use stack, but always push 2nd min value into stack;
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(min >= val){
            stack.push(min);
            min = val; 
        }
        stack.push(val);
    }
    
    public void pop() {
        //int temp = stack.pop();
        if(stack.pop() == min) min = stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
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