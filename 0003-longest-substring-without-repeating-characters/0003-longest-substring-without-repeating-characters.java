class Solution {
    public int lengthOfLongestSubstring(String s) {
        // sliding window 
        // use left and right to ensure the window
        // use set to make sure the substring doesn't have repeating characters
        // one pass
        // if there is repeating characters,shrink from the left until no repeating characters
        if(s.length() < 2) return s.length();
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while(right < s.length()){
            // substring(0,1), len = right - left;
            char c = s.charAt(right);

                while(left < right && set.contains(c)){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(c);
                right++;
                res = Math.max(res, right - left);
            
        }
        return res;
        
    }
}