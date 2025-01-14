class Solution {
    public int characterReplacement(String s, int k) {
        // use map
        // only one value can have bigger value than k; all the other value's sum should be <= k in the window; len - maxF <= k  
        // sliding window
        // once len - maxF > k,shrink window
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        int maxF = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxF = Math.max(maxF, map.get(c)); 
            while(right - left + 1 - maxF > k){
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
    
    
}