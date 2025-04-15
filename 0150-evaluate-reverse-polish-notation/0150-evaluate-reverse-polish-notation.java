class Solution {
    public int evalRPN(String[] tokens) {
        // use a stack to store elements
        // each time we get a number, push() into the stack
        // each time we get an opearator, pop() 2 elements and calculate, then push the result into stack
        // until the end of the tokens
        Deque<String> stack = new ArrayDeque<>();
        for(int i = 0; i < tokens.length; i++){
            String token = tokens[i];
            if(token.equals("+") || token.equals("-")  || token.equals("*") || token.equals("/")){
                int right = Integer.parseInt(stack.pop());
                int left = Integer.parseInt(stack.pop());
                if(token.equals("+")) stack.push((left + right)+"");
                else if(token.equals("-")) stack.push((left - right)+"");
                else if(token.equals("*")) stack.push((left * right)+"");
                else stack.push((left / right)+"");
            }
            else stack.push(token);
        }
        return Integer.parseInt(stack.pop());
        
    }
}