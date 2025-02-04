class Solution {
    public boolean canJump(int[] nums) {
        // travarse, update farthest index at each step
        int max = 0;
        if(nums.length==1) return true;
        for(int i = 0; i < nums.length ; i++){
            max = Math.max(nums[i] + i, max);
            // System.out.println(max);
            if(i < nums.length-1 && max==i) return false;

        }
        return true;
        
    }
}