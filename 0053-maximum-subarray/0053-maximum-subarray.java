class Solution {
    public int maxSubArray(int[] nums) {
        // calculate sum until now, if it's negative, discard it; if it's positive, add it;
        int sum_until_now = 0;
        int max_sum = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < nums.length ; i++){
            sum_until_now += nums[i];
            if(sum_until_now > max_sum) max_sum = sum_until_now;
            if(sum_until_now < 0) sum_until_now = 0;
        }
        return max_sum;
    }
}