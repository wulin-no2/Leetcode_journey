class Solution {
    boolean[] dp;
    public boolean canPartition(int[] nums) {
        // 1) sum must be even, or return false;
        // 2) find sub array so that their sum is sum/2;
        // dp[subsum] in array = dp[subsum-array[n-1]] in subarray;
        // calculate sum:
        int sum = 0;
        for(int i =0 ; i < nums.length ; i++) sum = sum + nums[i];
        if (sum % 2 != 0) return false;
        // 2) state transition equation:
        sum = sum / 2;
        // find if we can find sum of some elements from the array;
        dp = new boolean[sum + 1];
        
        dp[0] = true;
        for (int num : nums) {
            for (int j = sum; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[sum];
        
    }

}