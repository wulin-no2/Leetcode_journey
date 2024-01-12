class Solution {
    public String longestPalindrome(String s) {
        // from 16:30
        // from this solution:https://leetcode.com/problems/longest-palindromic-substring/discuss/4212564/Beats-96.49-oror-5-Different-Approaches-oror-Brute-Force-oror-EAC-oror-DP-oror-MA-oror-Recursion-oror
        // Manacher's Algorithm & DP
        /* first: O(N)
        if(s.length() == 1) return s;
        int maxLen = 1;
        String maxStr = s.substring(0, 1);
        s = "#" + s.replaceAll("","#") + "#";
        
        int[] dp = new int[s.length()];
        int center = 0;
        int right = 0;
        for(int i = 0; i < s.length(); i++){
            if(i < right) {
                dp[i] = Math.min(right - i, dp[2 * center - i]);
            }
            while(i - dp[i] - 1 >= 0 && i + dp[i] + 1 < s.length() && s.charAt(i - dp[i] - 1) == s.charAt(i + dp[i] + 1)){
                dp[i]++;
            }
            
            if(i + dp[i] > right){
                center = i;
                right = i + dp[i];
            }
            
            if(dp[i] > maxLen){
                maxLen = dp[i];
                maxStr = s.substring(i - maxLen, i + maxLen + 1).replaceAll("#","");
            }
        }
        return maxStr;
        */
        
        // Second: O(n^2)
        if (s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        int start = 0;
        int end = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); ++i) {
            dp[i][i] = true;
            for (int j = 0; j < i; ++j) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > maxLen) {
                        maxLen = i - j + 1;
                        start = j;
                        end = i;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }
}