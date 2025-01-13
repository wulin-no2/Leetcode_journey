class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // record the index of larger values
        // traverse from end to start
        // we should only record the indice whose value is larger than current elements
        // monotonic stack (from large to small, smaller on the top)
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for(int i = n - 1; i >= 0 ; i--){
            int temp = temperatures[i];
            while(! stack.isEmpty() && temp >= temperatures[stack.peek()]) stack.pop(); 
            if(! stack.isEmpty()) res[i] = stack.peek() - i; 
            stack.push(i);

        }
        return res;
        
    }
}