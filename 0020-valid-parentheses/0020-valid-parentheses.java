class Solution {
    public boolean isValid(String s) {
        // use a stack cause we have to match parentheses from the latest to the earlist
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0 ; i < s.length(); i++){
            // push left parenthesis into stack
            // pop element to match when it's a right parenthesis
            char c = s.charAt(i);
            if(c =='(' || c =='{' || c =='[') stack.push(c);
            else if(c ==')' || c =='}' || c ==']'){
                if(stack.isEmpty()) return false;
                char temp = stack.pop();
                if(c == ')' && temp != '(') return false;
                if(c == '}' && temp != '{') return false;
                if(c == ']' && temp != '[') return false;

            }
        }
        return stack.isEmpty();
    }
}