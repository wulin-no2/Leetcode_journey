class Solution {
    public int trap(int[] height) {
        /* 1st solution:
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
        */
        int left = 0, right = height.length - 1;
        int leftMax = height[0], rightMax = height[height.length - 1];
        int water = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                if (leftMax < height[left]) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
            } else {
                right--;
                if (rightMax < height[right]) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
            }
        }
        return water;
    }
}