class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp = Math.min(             )
         // dp[amount - coins[i]] + 1
        // dp[amount - coins[j]] + 1
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int j = 1; j <= amount; j++){
            for(int i = 0; i < coins.length ; i++){
                if(j >= coins[i]) dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
            }
        }
        if(dp[amount] > amount) return -1;
        return dp[amount];
    }
}