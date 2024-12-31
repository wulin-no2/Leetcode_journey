class Solution {
    public int maxProduct(int[] nums) {
        // dp
        int n = nums.length;
        if(n==1) return nums[0];
        int max = nums[0];
        int max_in = nums[0];
        int min_in = nums[0];

        for(int i = 1; i < n;i++){
            if (nums[i] < 0) {
                // Swap max_in and min_in when encountering a negative number
                int temp = max_in;
                max_in = min_in;
                min_in = temp;
            }
            // Update max_in and min_in for the current element
            max_in = Math.max(nums[i], max_in * nums[i]);
            min_in = Math.min(nums[i], min_in * nums[i]);
            // Update the global max
            max = Math.max(max, max_in);

        }
        return max;
    }
}