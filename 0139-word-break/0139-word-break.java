class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Convert wordDict to a HashSet for fast lookups
        Set<String> wordSet = new HashSet<>(wordDict);

        // Initialize a DP array
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // Base case: empty string can always be segmented

        // Fill the DP array
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further once dp[i] is true
                }
            }
        }

        return dp[s.length()];
    }
}