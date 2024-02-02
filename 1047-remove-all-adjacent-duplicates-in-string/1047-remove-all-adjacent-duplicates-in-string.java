class Solution {
    public String removeDuplicates(String s) {
        // use stack to handle adjacent letters;
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0 ; i < s.length() ; i ++){
            if(stack.isEmpty() || stack.peek() != s.charAt(i) ) stack.push(s.charAt(i));
            else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}