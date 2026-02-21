class Solution {
    public int evalRPN(String[] tokens) {
        // use stack
        // push numbers, get two numbers and calculate one we meet an operator
        Deque<Integer> stack = new ArrayDeque<>();
        for(String token: tokens){
            if("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)){
                int b = stack.pop();
                int a = stack.pop();
                int res;
                switch(token){
                    case "+":
                        {res = a + b; break;}
                    case "-":
                        {res = a - b; break;}
                    case "*":
                        {res = a * b; break;}
                    case "/":
                        {res = a / b; break;}
                    default:
                        res = 0;
                }
                stack.push(res);
            }
            else stack.push(Integer.parseInt(token));
        }
        return stack.peek();
        
    }
}