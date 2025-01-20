class Solution {
    public String longestPalindrome(String s) {
        // dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j). dp[i][j] means if s.substring(i, j + 1) is Palindrome;
        int n = s.length();
        if(n==1) return s;
        if(n==2) return s.charAt(0)==s.charAt(1) ? s : s.substring(0,1);
        String res = s.substring(0,1);
        int maxLength = 1;
        boolean[][] dp = new boolean[n][n];
        // all the single-letter substrings are valid
        for(int i = 0; i < n ; i++){
            dp[i][i] = true;

        }
        // for the length==2 substrings:
        for(int i = 0; i < n - 1 ; i++){
            if(s.charAt(i)==s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLength = 2;
                res = s.substring(i, i + 2);
            }
        }
        // for substrings of length >= 3:
        for(int len = 3; len <= n ; len++){
            for(int i = 0 ; i <= n - len; i++){
                int j = i + len - 1;
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if(dp[i][j] && len > maxLength){
                    maxLength = len;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;

    }
}