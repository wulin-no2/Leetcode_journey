class Solution {
    public boolean canJump(int[] nums) {
        // update the farthest index we can go at each index
        int farthest = 0;
        for(int i = 0; i < nums.length - 1; i++){
            farthest = Math.max(nums[i] + i, farthest);
            if(farthest <= i) return false;
        }
        return true;
        
    }
}