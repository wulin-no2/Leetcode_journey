class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) sum += num;
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        // 0-1 knapsack 
        // dynamic programming
        // dp[j] = dp[j] || dp[j-num]   //j is target, dp[j] is whether we can get target 
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for(int num: nums){
            for(int j = target; j >= 0; j--){
                if(j-num >= 0) dp[j] = dp[j] || dp[j-num];
            }
        }
        return dp[target];
        
    }
}