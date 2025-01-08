class Solution {
    public int lengthOfLIS(int[] nums) {
        // dp
        int n = nums.length;
        if(n==1) return 1;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        
        int maxLength = 1;

        for(int i = 1 ; i < n ; i++){
            for(int j = 0; j < i ; j++) if(nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
        
    }
}