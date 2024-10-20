class Solution {
    public boolean isValid(String s) {
        // use stack
        // if it's left bracket, push it;
        // if it's right bracket, pop it and compare it;
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c=='(') stack.push(')');
            else if(c=='[') stack.push(']');
            else if(c=='{') stack.push('}');
            else{
                if (stack.isEmpty() || stack.pop() != c) {
                    return false; // Not a valid match
                }
            }
        }
        return stack.isEmpty();
        
    }
}