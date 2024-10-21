class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // traverse from end to start
        // use stack to store the traversed elements
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        for(int i = temperatures.length - 1; i >= 0; i--){
            // for each elements
            // keep popping elements from stack until find a bigger one
            int temp = temperatures[i];
            // Pop elements from the stack if the current temperature is greater or equal
            // than the temperatures corresponding to the indices in the stack.
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temp) {
                stack.pop();
            }
            // If the stack is not empty, it means we found a warmer temperature in the future.
            // The number of days to wait is the difference in indices.
            if (!stack.isEmpty()) {
                res[i] = stack.peek() - i;
            }
            // Push the current index onto the stack
            stack.push(i);

        }
        return res;
    }
}