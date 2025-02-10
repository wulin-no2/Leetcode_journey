class Solution {
    public int jump(int[] nums) {
        // we traverse the array
        // at each position, update the farthest position it can arrive
        // every time we reach the end of current step, undate count and jump
        if(nums.length == 1) return 0;
        int count = 0;
        int farthest = 0;
        int currentEnd = 0;
        for(int i = 0; i < nums.length ; i++){
            farthest = Math.max(farthest, nums[i] + i);
            if(currentEnd == i) {
                count++;
                currentEnd = farthest;
                if(currentEnd >= nums.length - 1) return count;
            }
        }
        return count;
        
    }
}