class MinStack {
    // analyze:
    // use a variable of the class, each time we pop or push an elment, update the mininum;
    // the problem is,min value might duplicate. So we need to get the count of each value;
    // use array to store the counts of each count?No!!
    // use hashMap;??
    // no!! we can still use stack, but always push 2nd min value into stack;
    /*
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
    */
    
    // we can use stack to store int pair{val, min};
    // done at 18:42.1.11.2024
    private Stack<Pair<Integer, Integer>> stack;
    public MinStack(){
        stack = new Stack<>();
    }
    public void push(int val){
        if(stack.isEmpty()){
            stack.push(new Pair<>(val,val));
        }
        else{
            int min = Math.min(stack.peek().getValue(), val);
            stack.push(new Pair<>(val, min));
        }
    }
    public void pop(){
        if(!stack.isEmpty()){
            stack.pop();
        }
    }
    public int top(){
        if(stack.isEmpty()){
            return 0;
        }
        return stack.peek().getKey();
    }
    public int getMin(){
        if(stack.isEmpty()){
            return 0;
        }
        return stack.peek().getValue();
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