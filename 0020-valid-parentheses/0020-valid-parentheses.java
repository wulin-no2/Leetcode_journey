class Solution {
    public boolean isValid(String s) {
        // this means we need to pair them up;
        // each time we have a right signal, the left one must be the matched left signal;
        // put left into stack; each time we have a right signal, try to match them;
        // turn s into array so it can be processed quickly.
        // char[] arr = new char[s.length()];
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(') stack.push(')');
            else if(c=='{') stack.push('}');
            else if(c=='[') stack.push(']');
            // match them if it's a right signal;
            else if(stack.isEmpty() || stack.pop()!= c) return false;
        }
        return stack.isEmpty();
        
        
    }
}