class Solution {

    public String removeDuplicates(String s) {
        // my own solution:
        // /*
        // use stack to handle adjacent letters;
        Deque<Character> stack = new LinkedList<>();
        char[] arr = s.toCharArray();
        for(int i = 0 ; i < arr.length ; i ++){
            if(stack.isEmpty() || stack.peek() != arr[i]) stack.push(arr[i]);
            else {
                stack.pop();
            }
        }
        String res = "";
        while(!stack.isEmpty()){
            res = stack.pop() + res;
        }
        return res;
        /*StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        return sb.toString();
        */
        // */
        
        // from camp: fast slow approach:
        /*
        char[] ch = s.toCharArray();
        int fast = 0;
        int slow = 0;
        while(fast < s.length()){
            // 直接用fast指针覆盖slow指针的值
            ch[slow] = ch[fast];
            // 遇到前后相同值的，就跳过，即slow指针后退一步，下次循环就可以直接被覆盖掉了
            if(slow > 0 && ch[slow] == ch[slow - 1]){
                slow--;
            }else{
                slow++;
            }
            fast++;
        }
        return new String(ch,0,slow);
        */
    }
}