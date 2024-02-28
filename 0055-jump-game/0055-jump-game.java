class Solution {
    public boolean canJump(int[] nums) {
        // each step, we calculate the farest index;
        // if the farest == curIndex && curIndex < length, return false; else, return true;
        int farest = 0;
        for(int i = 0 ; i < nums.length ; i++){
            farest = Math.max(nums[i] + i, farest);
            if(farest == i && i < nums.length - 1) return false;
        }
        return true;
    }
}