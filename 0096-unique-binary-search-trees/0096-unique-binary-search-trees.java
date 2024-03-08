class Solution {
    public int numTrees(int n) {
        //dp[i] = dp[i - 1] + dp[i - 1] + dp[i - 2];
        // which means;
        // n node as the root: dp[n - 1];
        // n node as the lower right corner / leaf: dp[n - 1];
        // n node at layer higher than leaf: dp[n - 2];
        //       which equals n - 1 node at lower right corner;
        if(n < 3) return n;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}