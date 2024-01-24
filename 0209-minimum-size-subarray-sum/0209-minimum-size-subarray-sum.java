class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // for 0 on, find a subarray[left, right]; use int to store left and right and sum;
        // move right, if sum is bigger, try to remove first until sum is bigger than target;
        // if sum is smaller, keep moving right until sum is bigger than target;
        int left = 0;
        int right = 0;
        int sum = nums[0];
        // find the first window;
        while(sum < target && right < nums.length - 1){
            right++;
            sum = sum + nums[right];
        }
        //System.out.println(" sum: " + sum + " right: " + right);
        if(sum < target) return 0;
        int len = right - left + 1;
        // sliding window:
        while(right <= nums.length - 1){
            if(right == nums.length - 1 && sum < target) break;
            if(sum >= target){
                while(sum >= target){
                    left++;
                    sum = sum - nums[left - 1];
                    //System.out.println(" while sum: " + sum + " right: " + right + " left: " + left);
                }
                left--;
                sum = sum + nums[left];
                len = Math.min(len, right - left + 1);
                if(right == nums.length - 1) return len;
                //System.out.println(" len: " + len + " sum: " + sum + " right: " + right + " left: " + left);
            }
            if(right < nums.length - 1){
                right++;
                left++;
                sum = sum - nums[left - 1] + nums[right];
                
                //System.out.println(" sum: " + sum + " right: " + right + " left: " + left);
            }
        }
        return len;
    }
}