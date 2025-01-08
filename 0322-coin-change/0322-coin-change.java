class Solution {
    public int coinChange(int[] coins, int amount) {
        // typical unbounded knapsack question
        // choose infinite amount of goods and see it we can reach a goal
        // dp[j] = Math.min (dp[j] || dp[j - coin] + 1); // j means amount; dp[j] means we can reach amount j with current goods
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int j = 1; j <= amount; j++){
            dp[j] = amount + 1;
        }
        for(int coin: coins){
            for(int j = 0 ; j <= amount; j++){
                if(j-coin >= 0) dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        return dp[amount]==amount + 1? -1:dp[amount];
        
    }
}