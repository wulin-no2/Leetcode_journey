class Solution {
    public int maxProfit(int[] prices) {
        // traverse the array; get max_until_now in each index
        // return Math.max(0, max_until_now);
        int max_until_now = 0;
        int smallest_until_now = prices[0];
        for(int price: prices){
            smallest_until_now = Math.min(smallest_until_now, price);
            max_until_now = Math.max(max_until_now, price-smallest_until_now);
        }
        return Math.max(0, max_until_now);
    }
}