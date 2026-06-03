class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // find the next greater element
        // use monotonic stack
        // put candidates on a stack, candidates should be index so we can calculate result;
        // once we got a greater one(compare with stack.peek()), keep popping and we get elements in res, the push it into stack for next compare;
        // otherwise, push it into stack;
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n ; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int topCandidate = stack.pop();
                res[topCandidate] = i - topCandidate;
            }
            stack.push(i);
        }
        return res;
        // int n = temperatures.length;
        // int[] res = new int[n];

        // Deque<Integer> stack = new ArrayDeque<>(); // store index

        // for (int i = 0; i < n; i++) {
        //     while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        //         int prevIndex = stack.pop();
        //         res[prevIndex] = i - prevIndex;
        //     }

        //     stack.push(i);
        // }

        // return res;    
    }
}