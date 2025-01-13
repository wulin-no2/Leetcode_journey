class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // check if there is a larger element after each element's position and calculate their difference of indice
        // traverse from end to start
        Deque<Integer> stack = new LinkedList<>();
        int n = temperatures.length;
        int[] res = new int[n];
        for(int i = n-1 ; i >= 0 ; i--){
            // for each element, keep popping until find a bigger one
            int temp = temperatures[i];
            while(! stack.isEmpty() && temperatures[stack.peek()] <= temp) stack.pop();
            if(! stack.isEmpty()) res[i] = stack.peek() - i;
            // Push the current index into the stack
            stack.push(i);
        }
        return res;
        
    }
}