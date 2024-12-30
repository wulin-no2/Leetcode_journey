class Solution {
    public String longestPalindrome(String s) {
        // dp
        // dp[i][j] = dp[i+1][j-1] && s[i]==s[j]
        int n = s.length();
        if (n <= 1) return s; 

        int maxLength = 1;
        String res = s.substring(0,1);

        boolean[][] dp = new boolean[n][n]; 
        // Base case: Single-character substrings
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Base case: Two-character substrings
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                res = s.substring(i, i + 2);
                maxLength = 2;
            }
        }

        // DP for substrings longer than 2 characters
        for (int len = 3; len <= n; len++) { // Length of the substring
            for (int i = 0; i <= n - len; i++) { // Start index
                int j = i + len - 1; // End index
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (len > maxLength) {
                        maxLength = len;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res; 
    }
}