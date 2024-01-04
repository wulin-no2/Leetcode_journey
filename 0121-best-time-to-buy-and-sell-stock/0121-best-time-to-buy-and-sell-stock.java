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
            // if(prices[i] < minPrice){
            //     minPrice = prices[i];
            // }
            // replace the if with Math.min
            minPrice = Math.min(prices[i],minPrice);
            // if(prices[i] - minPrice > maxResult){
            //     maxResult = prices[i] - minPrice;   
            // }
            // replace the if with Math.max
            maxResult = Math.max(prices[i]-minPrice, maxResult);
        }
        return maxResult;
    }
}