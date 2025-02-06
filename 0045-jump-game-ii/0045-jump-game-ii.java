class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0; // No jumps needed if already at the last index

        int jumps = 0, farthest = 0, currentEnd = 0;
        
        for (int i = 0; i < n - 1; i++) { // No need to check the last index
            farthest = Math.max(farthest, i + nums[i]);
            
            // When we reach the end of the current range, increment the jump
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
                
                // If we've reached or surpassed the last index, return jumps
                if (currentEnd >= n - 1) return jumps;
            }
        }
        return jumps;
    }
}