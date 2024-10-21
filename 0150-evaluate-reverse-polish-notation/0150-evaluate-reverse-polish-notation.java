class Solution {
    public int evalRPN(String[] tokens) {
        // use stack to store the elements
        // everytime we meet an operator, pop 2 elements and push the result
        // until the traversal is over
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(String token: tokens){
            if(token.equals("+") || token.equals("-") || 
               token.equals("*") ||token.equals("/") ) {
                int a = stack.pop();
                int b = stack.pop();
                if(token.equals("+") ) stack.push(a+b);
                else if(token.equals("-")) stack.push(b-a);
                else if(token.equals("*")) stack.push(a*b);
                else if(token.equals("/")) stack.push(b/a);
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
        
    }
}