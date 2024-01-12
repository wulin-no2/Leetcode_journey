class Solution {
    public int uniquePaths(int m, int n) {
        // from 19:50
        // find dp logic; dp[m][n] means how many unique ways can we find for grid[m][n]
        // dp[m][n] vs dp[m][n - 1]: 
        // dp[m][n] = dp[m][n - 1] + dp[m - 1][n];
        // we assume move right = 1,move down = 0;
        // then each step should 0 or 1;
        // the whole step = m - 1 + n - 1; We can use combinational approach; go m - 1's 1;
        
        /* O(N2) O(N2)
        int[][] dp = new int[m][n];
        
        // watch the base case!!!
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for(int i = 1; i < m ; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }   
        return dp[m - 1][n - 1];
    
        */
        // another solution. why?
        long ans = 1;
        for (int i = 1; i <= m - 1; i++) {
            ans = ans * (n - 1 + i) / i;
        }
        return (int)ans;
    }
}