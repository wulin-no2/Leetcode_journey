class Solution {
    public int maxProfit(int[] prices) {
        // one pass
        if(prices.length==1) return 0;
        int res = 0;
        int profit_today = 0;
        int cost = prices[0];
        for(int i = 1 ; i < prices.length ; i++){
            cost = Math.min(cost, prices[i - 1]);
            profit_today = prices[i] - cost;
            res = Math.max(profit_today, res);
        }
        return res;
        
    }
}