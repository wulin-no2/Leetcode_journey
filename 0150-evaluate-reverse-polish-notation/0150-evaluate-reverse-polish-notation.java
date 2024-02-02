class Solution {
    public int evalRPN(String[] tokens) {
        // use stack, each time we came across non number,  pop() twice;
        // or we push it;
        if(tokens == null || tokens.length == 0) return 0;
        Deque<Integer> stack = new LinkedList<>();
        String operators = "+-*/";
        for(int i = 0 ; i < tokens.length ; i ++){
            if(operators.contains(tokens[i])){
                int num2 = stack.pop();
                int num1 = stack.pop();
                if(tokens[i].equals("+")) stack.push(num1 + num2);
                if(tokens[i].equals("-")) stack.push(num1 - num2);
                if(tokens[i].equals("*")) stack.push(num1 * num2);
                if(tokens[i].equals("/")) stack.push(num1 / num2);
            }
            else stack.push(Integer.valueOf(tokens[i]));              
        }
        return stack.pop();
                                                 
        
        
        
        
        
        
        
        // analyze:
        // traverse:
        // 1) if number, push to stack;
        // 2) if operator, pop twice; 2nd is on the left of the operator;
        //    push the result to stack;
        // 3) loop until no more tokens and stack is empty;
        
        // from 17:11; 20min;
        // need to convert string to int or operator;
        // TC O(N) SC O(N)
        /* complex:
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
        */
        /* before:
        if(tokens == null || tokens.length == 0) return 0;
        Deque<Integer> stack = new LinkedList<>();
        String operators = "+-* /";
        for(int i = 0;i< tokens.length;i++){
            if(operators.contains(tokens[i])){
                int num1 = stack.pop();
                int num2 = stack.pop();
                if(tokens[i].equals("+")) stack.push(num2 + num1);
                else if(tokens[i].equals("-"))stack.push(num2 - num1);
                else if(tokens[i].equals("*"))stack.push(num2 * num1);
                else if(tokens[i].equals("/"))stack.push(num2 / num1);
            }else stack.push(Integer.valueOf(tokens[i]));
        }
        return stack.peek();
        */
    }
}