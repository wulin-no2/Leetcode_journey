class Solution {
    public int climbStairs(int n) {
        // dp[n] = dp[n - 1] + d[n - 2];
        if(n<=2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
        
        // we can recursive it.
        // it's great but it's exponential time complexity. performance is bad;
        /*
        if(n <= 3){
            return n;
        }
        return climbStairs(n-1) + climbStairs(n-2);
        */
        
        // find a way to avoid recursive;
        /* approach1: dynamic programming, time and space complexityO(n)
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
        */
        
        // approach2:memorization, time and space complexityO(n)
        // use a map to memorize computed results for each step n
        /*
        HashMap<Integer, Integer> map = new HashMap<>();
        if(n <= 3) return n;
        for(int i = 0; i <= 3; i++) map.put(i,i);
        for(int i = 4; i <= n; i++) map.put(i, map.get(i-1) + map.get(i - 2));
        return map.get(n);
        */
    }
}
