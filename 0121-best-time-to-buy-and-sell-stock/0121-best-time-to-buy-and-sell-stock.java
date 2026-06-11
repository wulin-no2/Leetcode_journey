class Solution {
    public int maxProfit(int[] prices) {
        // assume we might see it everyday, update the max profit day by day
        int max = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int price: prices){
            max = Math.max(max, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return max;
        
    }
}