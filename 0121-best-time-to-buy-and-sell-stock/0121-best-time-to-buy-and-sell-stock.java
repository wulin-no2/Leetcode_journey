class Solution {
    public int maxProfit(int[] prices) {
        // we can traverse the array
        // calculate the max profit we can make on each day
        // then return the maximum value of the results
        // so have to track the smallest value so we can get the max profit on the day
        int res = 0;
        int min_until_now = prices[0];
        for(int price: prices){
            int profit = price - min_until_now;
            res = Math.max(profit, res);
            min_until_now = Math.min(min_until_now, price);
        }
        return res;
        
    }
}