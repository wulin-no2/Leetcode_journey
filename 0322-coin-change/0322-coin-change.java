class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp
        // dp[i] amount == i result
        // traverse coins to see if we should include it or not
        // for each coin: dp[i] = Math.min(dp[i-coin] + 1, dp[i])
        // update result each step
        int n = coins.length;
        if(amount==0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // fill dp with unreachable values
        dp[0]=0;
        for(int coin: coins){
            for(int i = coin; i <= amount; i++){
                dp[i] = Math.min(dp[i-coin] + 1, dp[i]);
            }
        }
        return dp[amount]==amount+1? -1: dp[amount];


        
    }
}