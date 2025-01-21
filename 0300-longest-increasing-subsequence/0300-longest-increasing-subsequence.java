class Solution {
    public int lengthOfLIS(int[] nums) {
        // dp
        // dp[i] = Math.max(dp[i], dp[j] + 1); dp[i] means if the last element we choose if the ith element,
        // what the longest increasing subsequence would be 
        // only when j < i, and nums[j] < nums[i]
        // use 2 for-loops to find all the possible subsequence
        int n = nums.length;
        int max = 0;
        if(n == 0 || n == 1) return n;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i ; j++){
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
                max = Math.max(max, dp[i]);
            }
        }

        return max;
    }
}