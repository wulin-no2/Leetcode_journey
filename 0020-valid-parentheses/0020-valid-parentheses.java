class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        if (len % 2 != 0) return false;
        // use stack
        // push left brackets in stack and then pop out when there is a right bracket
        Deque<Character> stack = new ArrayDeque<>();
        int i = 0;
        while(i < len){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') stack.push(c);
            else{
                if(stack.isEmpty()) return false;
                if(c == ')' && stack.peek() == '(') stack.pop();
                else if (c == '}' && stack.peek() == '{') stack.pop();
                else if (c == ']' && stack.peek() == '[') stack.pop();
                else return false;
            }
            i++;
        }
        return stack.isEmpty();
    }
}