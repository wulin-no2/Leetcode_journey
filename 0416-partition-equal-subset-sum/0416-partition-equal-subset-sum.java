class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];

        // initialize
        dp[0] = true;

        // 0-1 knapsack, must update snapsack from end to start
        for(int num: nums){
            for(int i = target; i >= num ; i--){
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }
}