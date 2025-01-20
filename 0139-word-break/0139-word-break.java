class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // use set to store teh wordbook for quick check
        Set<String> set = new HashSet<>();
        for(String str : wordDict) set.add(str);
        // dp[i] first i chars
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        // dp[i] = dp[j] && set.contains(s.substring(j, i + 1));
        for(int i = 1; i <= n ; i ++){
            for(int j = 0; j < i ; j++){
                if(dp[j] && set.contains(s.substring(j, i))) {dp[i] = true; break;}
                
            }
        }
        return dp[n];
        
    }
}