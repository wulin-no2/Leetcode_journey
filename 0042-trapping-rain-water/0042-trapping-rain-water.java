class Solution {
    public int trap(int[] height) {
        /* 1st solution:don't understand:
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
        // another approach: 2 pointers. don't understand:
        /*
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
        */
        
        // solution3: following is brute force approach: o(n^2) sloooooow; last 1;
        /* easy understand;
          int n = height.length;
          int totalWater = 0;
          for (int k = 0; k < n; ++k) {
            int leftMax = 0;
            for (int i = 0; i <= k - 1; ++i) {
              leftMax = Math.max(leftMax, height[i]);
            }
            int rightMax = 0;
            for (int i = k + 1; i < n; ++i) {
              rightMax = Math.max(rightMax, height[i]);
            }
            int water = Math.min(leftMax, rightMax) - height[k];
            totalWater += (water > 0) ? water : 0;
          }
          return totalWater;
          */
        // solution4 : DP,based on solution3, but get leftMax and rightMax first to improve efficiency;
        /* easy understand;
          int n = height.length;
          if (n <= 2) return 0;
          // pre-compute
          int[] leftMax = new int[n];
          int[] rightMax = new int[n];
          leftMax[0] = height[0]; // init
          rightMax[n - 1] = height[n - 1];
          for (int i = 1, j = n - 2; i < n; ++i, --j) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
          }
          // water
          int totalWater = 0;
          for (int k = 1; k < n - 1; ++k) { // do not consider the first and the last places
            int water = Math.min(leftMax[k - 1], rightMax[k + 1]) - height[k];
            totalWater += (water > 0) ? water : 0;
          }
          return totalWater;
        */ 
          int n = height.length;
          int lo = 0, hi = n - 1;
          int leftMax = 0, rightMax = 0;
          int water = 0;
          while (lo < hi) {
            // update
            if (height[lo] > leftMax)  leftMax = height[lo];
            if (height[hi] > rightMax) rightMax = height[hi];
            // compute
            if (leftMax < rightMax) { // consider the min
                water += (leftMax - height[lo]); // leftMax >= height[lo]
                ++lo;
            } else {
                water += (rightMax - height[hi]);
                --hi;
            }
          }
          return water;
        
    }
}