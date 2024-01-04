class Solution {
    public int maxProfit(int[] prices) {
        // analyze:
        // Everyday, find the minPrice and the maxResult.
        if(prices.length <= 1){
            return 0;
        }
        int maxResult = 0;
        int minPrice = prices[0];
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            if(prices[i] - minPrice > maxResult){
                maxResult = prices[i] - minPrice;   
            } 
        }
        return maxResult;
    }
}