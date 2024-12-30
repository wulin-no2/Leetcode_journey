class Solution {
    public int countSubstrings(String s) {
        // dp
        // if it is palindrom: dp[i][j] = dp[i+1][j-1] && s.charAt(i)==s.charAt(j);
        int n = s.length();
        if(n==1) return 1;
        boolean[][] dp = new boolean[n][n];
        int res = 0;
        // handle length == 1 cases:
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
            res++;
        }
        // handle length == 2 cases:
        for(int i = 0; i < n - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                res++;
            }
        }
        // handle length == 3+ cases:
        for(int len = 3; len <= n ; len++){
            for(int i = 0; i < n - len + 1; i++){
                int j = i + len - 1;
                if(dp[i+1][j-1] && s.charAt(i)==s.charAt(j)) {
                    dp[i][j] = true; // Update DP table
                    res++;
                }
            }
        }
        return res;
        
    }
}