class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);
        return Math.max(robber(nums, 0, n - 2), robber(nums, 1, n - 1));
    }
    public int robber(int[] nums, int i, int j){
        // dp
        int n = nums.length;
        if(n==1) return nums[0];
        int[][] dp = new int[n][n];
        dp[i][i] = nums[i];
        dp[i][i + 1] = Math.max(nums[i], nums[i + 1]);

        for(int m = 2; m < n; m++){
            dp[i][m] = Math.max(dp[i][m - 1], dp[i][m - 2] + nums[m]);
        }
        return dp[i][j];
    }
}