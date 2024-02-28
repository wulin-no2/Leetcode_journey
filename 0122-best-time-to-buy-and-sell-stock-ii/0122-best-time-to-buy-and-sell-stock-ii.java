class Solution {
    public int maxProfit(int[] prices) {
        int maxSum = 0;
        //int maxCur = 0;
        for(int i = 1 ; i < prices.length ; i++){
            maxSum = Math.max(prices[i]-prices[i-1], 0) + maxSum;
        }
        return maxSum;
        
    }
}