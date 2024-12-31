class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') return 0; // No valid decoding for leading '0'

        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: empty string has one way to decode
        dp[1] = s.charAt(0) == '0' ? 0 : 1; // Single digit '0' is invalid

        for (int i = 2; i <= n; i++) {
            int singleDigit = s.charAt(i - 1) - '0'; // Current character
            int twoDigit = Integer.parseInt(s.substring(i - 2, i)); // Two-character substring

            if (singleDigit >= 1 && singleDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
