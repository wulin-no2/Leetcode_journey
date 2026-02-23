class Solution {
    public int evalRPN(String[] tokens) {
        // use stack
        // push numbers, get two numbers and calculate one we meet an operator
        Deque<Integer> stack = new ArrayDeque<>();
        for(String token: tokens){
            switch(token){
                case "+" ->  stack.push(stack.pop() + stack.pop());
                case "*" ->  stack.push(stack.pop() * stack.pop());
                case "-" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                }
                case "/" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
        
    }
}