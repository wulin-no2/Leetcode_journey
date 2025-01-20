class Solution {
    public int numDecodings(String s) {
        // dp
        // dp[i] means a string with length i can have dp[i] decode ways
        // dp[i] += dp[i - 1] if(s.charAt(i-1) is from 0 to 9)
        // dp[i] += dp[i - 2] if(finalTwoDigits is from 10 to 26)
        int n = s.length();
        if(n==0 || s.charAt(0)=='0') return 0;
        if(n==1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1; // how?
        dp[1] = 1; // should I discuss s.charAt(0)=='0' here?
        for(int i = 2; i <= n; i++){
            int oneDigit = s.charAt(i - 1)-'0';
            int twoDigits = Integer.parseInt(s.substring(i- 2, i));
            if(oneDigit >= 1 && oneDigit <= 9) dp[i] += dp[i - 1];
            if(twoDigits >= 10 && twoDigits <= 26) dp[i] += dp[i - 2];
        }
        return dp[n];
    }
}