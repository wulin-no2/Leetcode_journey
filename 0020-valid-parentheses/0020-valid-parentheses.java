class Solution {
    public boolean isValid(String s) {
        // use stack to push() left brackets's pair right brackets, once we have right brackets, pop() and compare;
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0; i < s.length() ; i ++){
            if(s.charAt(i) == '(') stack.push(')');
            else if(s.charAt(i) == '[') stack.push(']');
            else if(s.charAt(i) == '{') stack.push('}');
            else if(!stack.isEmpty()){
                Character c = stack.pop();
                if(c.equals(s.charAt(i))) continue;
                else return false;
            }
            else return false;
        }
        if(!stack.isEmpty()) return false;
        return true;
        
        
        
        
        
        
        
        
        
        
        /* this was the first time I did this problem and I couldn't solve it.
        if(s.charAt(0) == ')'|| s.charAt(0)  == ']'||s.charAt(0) == '}'){
            return false;
        }
        for(int i = 0 ; i < s.length(); i ++){
            if ((s.charAt(i) == '(' && s.charAt(i + 1)!= ')') ||
                (s.charAt(i) == '[' && s.charAt(i + 1)!= ']') ||
                (s.charAt(i) == '{' && s.charAt(i + 1)!= '}')){
                return false;
            }
        }
        return true;
        */
        
        // this is the second time I do it at 18:01, Jan 5th, 2024;
        
        // analyze:
        // push the elements of the string into a stack if it's an open bracket;
        // pop an elements and check if they are a pair if the next is a close bracket;
        // if it's not a pair, return false;
        // if the stack is empty and the string is traversed, return true;
        /* my solution before:
        Stack stack = new Stack();
        int n = s.length();
        int i = 0;
        while(i < n){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' ){
                stack.push(s.charAt(i));
                i++;
            }
            else{
                if(!stack.isEmpty()){
                    // check if they are a pair:
                    char c =(char)stack.pop();
                    if((c == '(' && s.charAt(i) == ')') ||
                       (c == '[' && s.charAt(i) == ']') ||
                       (c == '{' && s.charAt(i) == '}')
                       ){
                        i++;
                    } else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
        */
    }
}