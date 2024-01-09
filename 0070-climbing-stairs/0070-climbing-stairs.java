class Solution {
    public int climbStairs(int n) {
        // we can recursive it.
        // it's great but it's exponential time complexity. performance is bad;
        /*
        if(n <= 3){
            return n;
        }
        return climbStairs(n-1) + climbStairs(n-2);
        */
        
        // find a way to avoid recursive;
        if(n <= 3){
            return n;
        }
        // dynamic programming;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}