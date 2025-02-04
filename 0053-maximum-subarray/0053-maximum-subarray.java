class Solution {
    public int maxSubArray(int[] nums) {
        // traverse, at each position, check sum_until_now, if it's >= 0, we keep it;
        // if it's < 0, we dump it;
        int res = nums[0];
        int sum_until_now = nums[0];
        
        for(int i = 1; i < nums.length ; i++){
            if(sum_until_now < 0) sum_until_now = nums[i];
            else sum_until_now += nums[i];
            res = Math.max(res, sum_until_now);
            
        }
        return res;

        
    }
}