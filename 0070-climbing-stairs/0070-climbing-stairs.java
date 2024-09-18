class Solution {
    public int climbStairs(int n) {
        // 1. dp definition: for n steps stairs, we have dp[n] ways to the top;
        int[] dp = new int[n + 1];
        
        // 2. dp equations
        //dp[n] = dp[n-1] + dp[n-2];
        
        // 3. initialize
        dp[1] = 1; if(n==1) return dp[1]; 
        dp[2] = 2;
        // 4. how to traverse
        for(int i = 3; i <= n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
            //System.out.println("dp["+n+"] is "+dp[n]);
        }
        // 5. result
        return dp[n];
    }
}