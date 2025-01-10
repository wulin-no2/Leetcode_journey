class Solution {
    public int evalRPN(String[] tokens) {
        // use a stack 
        // each time we meet a operator, get 2 elements for the stack; put the result into stack
        // each time we meet a number, put it into the stack
        Deque<Integer> stack = new LinkedList<>();
        for(String token: tokens){
            char c = token.charAt(0);
            if(token.length()==1 && c=='+') {
                int b = stack.pop();
                int a = stack.pop();
                int res = a + b;
                stack.push(res);
            }else if(token.length()==1 && c=='-') {
                int b = stack.pop();
                int a = stack.pop();
                int res = a - b;
                stack.push(res);
            }else if(token.length()==1 && c=='*') {
                int b = stack.pop();
                int a = stack.pop();
                int res = a * b;
                stack.push(res);
            }else if(token.length()==1 && c=='/') {
                int b = stack.pop();
                int a = stack.pop();
                int res = a / b;
                stack.push(res);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
        
    }
}