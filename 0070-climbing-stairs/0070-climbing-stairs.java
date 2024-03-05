class Solution {
    public int climbStairs(int n) {
        // dp[n] = dp[n - 1] + d[n - 2];
        /*
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
        */
        if(n < 3) return n;
        int a = 1;
        int b = 2;
        for(int i = 3; i <= n; i++){
            int res = a + b;
            a = b;
            b = res;
        }
        return b;
        
        

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
