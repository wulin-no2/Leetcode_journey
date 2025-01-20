class Solution {
    public int countSubstrings(String s) {

        // if( s.charAt(i)==s.charAt(j) && dp[i][j] = dp[i + 1][j-1]) dp[i][j] = true; res++;
        int res = 0;
        int n = s.length();
        if(n==1) return 1;
        boolean[][] dp = new boolean[n][n];
        // for length = 1 substrings
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
            res++;
        }

        // for length = 2 substrings
        for(int i = 0; i < n - 1; i++){
            if(s.charAt(i)==s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                res++;
            }
        }

        // for length >= 3 substrings
        for(int len = 3 ; len <= n ; len++){
            for(int i = 0; i <= n - len ; i++){
                int j = i + len - 1;
                dp[i][j] = s.charAt(i)==s.charAt(j) && dp[i + 1][j - 1];
                if(dp[i][j]==true) res++;
            }
        }
        return res;
        
    }
}