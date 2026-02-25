class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        int min_until = prices[0];
        for(int price: prices){
            // assume we sell it today
            int profit = price - min_until;
            min_until = Math.min(min_until, price);
            max_profit = Math.max(max_profit, profit);
        }
        return max_profit;
        
    }
}