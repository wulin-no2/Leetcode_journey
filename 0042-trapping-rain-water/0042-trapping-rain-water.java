class Solution {
    public int trap(int[] height) {
        // if (height == null) return 0;  //unnecessary in this case bc n == height.length, 1 <= n <= 2 * 104
        int i     = 0;
        int water = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        while (i < height.length) {
            if (stack.isEmpty() || height[i] <= height[stack.peek()]) stack.push(i++);
            else {
                int pre = stack.pop();
                if (!stack.isEmpty()) {
                    //get smaller height of the two sides
                    int minHeight = Math.min(height[stack.peek()], height[i]);
                    //calculate water filled area
                    water += (minHeight - height[pre]) * (i - stack.peek() - 1);
                }
            }
        }
        return water;
        
    }
}