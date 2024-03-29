class Solution {
    public int uniquePaths(int m, int n) {
        // dp again;
        // dp[i][j] = dp[i-1][j] + dp[i][j-1];
        // dp[i][j] means how many unique paths from [0][0] to [i][j];
        int[][] dp = new int[m][n];
        // base case:
        for(int j = 0; j < n ; j++){
            dp[0][j] = 1;
        }
        for(int i = 0; i < m ; i++){
            dp[i][0] = 1;
        }
        
        // for loop order:
        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m-1][n-1];
    
        
        // another solution. why?
        /*
        long ans = 1;
        for (int i = 1; i <= m - 1; i++) {
            ans = ans * (n - 1 + i) / i;
        }
        return (int)ans;
        */
    }
}