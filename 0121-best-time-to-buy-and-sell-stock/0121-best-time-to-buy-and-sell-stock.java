class Solution {
    public int maxProfit(int[] prices) {
        // dynamic programming
        // dp[j][0] jth day we don't hold a stock, how much we have;
        // dp[j][1] jth day we hold a stock, how much we have;
        // dp[j][0] = max{dp[j - 1][0], dp[j - 1][1] + prices[j]};
        // dp[j][1] = max{dp[j - 1][1], dp[j - 1][0] - prices[j]};
        // int result = max{dp[j][0], dp[j][1]};
        // we need dp[prices.size()-1][0];
        int length = prices.length;
        int[][] dp = new int[length][2];
        
        // initialize it:
        dp[0][0]=0;
        dp[0][1]= -prices[0];
        
        //calculate:
        for(int j = 1; j < length; j++){
            dp[j][0] = Math.max(dp[j - 1][0], dp[j - 1][1] + prices[j]);
            dp[j][1] = Math.max(dp[j - 1][1], - prices[j]);
        }
        return dp[length-1][0];
    }
}