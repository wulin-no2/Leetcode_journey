class Solution {
    public int evalRPN(String[] tokens) {
        // analyze:
        // traverse:
        // 1) if number, push to stack;
        // 2) if operator, pop twice; 2nd is on the left of the operator;
        //    push the result to stack;
        // 3) loop until no more tokens and stack is empty;
        
        // from 17:11
        // need to convert string to int or operator;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int res = Integer.parseInt(tokens[0]);
        stack.push(res);
        while(!stack.isEmpty() && i < tokens.length - 1){
            i++;
            if(tokens[i].equals("+")){
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left + right);
            }
            else if(tokens[i].equals("-")){
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left - right);
            }
            else if(tokens[i].equals("*")){
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left * right);
            }
            else if(tokens[i].equals("/")){
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left / right);
            }
            else stack.push(Integer.parseInt(tokens[i]));
            
            if(i==tokens.length - 1) res = stack.pop();
        }
        return res;
        
    }
}