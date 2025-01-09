class Solution {
    public boolean isValid(String s) {
        // stack 
        // push open brackets into stack
        // pop it when there is a close bracket
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c=='(') stack.push(c);
            if(c=='[') stack.push(c);
            if(c=='{') stack.push(c);
            
            if(c==')'){
                if(stack.isEmpty()) return false;
                char temp = stack.pop();
                if(temp!='(') return false;
            };
            if(c==']'){
                if(stack.isEmpty()) return false;
                char temp = stack.pop();
                if(temp!='[') return false;

            }
            if(c=='}'){
                if(stack.isEmpty()) return false;
                char temp = stack.pop();
                if(temp!='{') return false;
            }

        }
        return stack.isEmpty();
    }
}