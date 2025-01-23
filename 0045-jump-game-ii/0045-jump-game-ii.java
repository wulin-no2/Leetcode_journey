class Solution {
    public int jump(int[] nums) {
        // update farthest position and count of steps to reach it at every step
        int farthest = 0;
        int n = nums.length;
        int count = 0;
        int currentEnd = 0; // The end of the current jump range

        for(int i = 0; i < n - 1 ; i++){
            farthest = Math.max(farthest, i + nums[i]); // Update the farthest we can reach
            
            // If we've reached the end of the current jump range, we need to jump
            if (i == currentEnd) {
                count++; // Increment jump count
                currentEnd = farthest; // Update the jump range to the farthest we can reach
                
                // If the farthest position covers the last index, we can stop
                if (currentEnd >= n - 1) break;
            }
        }
        return count;
    }
}