class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // next bigger value
        // monotonic stack - decrease
        // at each index, we decide if the previous candidates can be solved
        // only those elements that are small than current element will get their answer
        // if current element is small than or equal to candicates, then it should join candidates
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            // if(stack.isEmpty() || temperatures[i] <= stack.peek()) {
            //     stack.push(i);
            //     continue;
            // }
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int index = stack.pop();
            res[index] = 0;

        }
        return res;
        
    }
}