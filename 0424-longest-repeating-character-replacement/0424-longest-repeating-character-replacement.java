class Solution {
    public int characterReplacement(String s, int k) {
        // for each substring, if the lengthOfSubstring - maxFrequency <= k, then this is a valid result;
        // use slidingwindow, if lengthOfSubstring - maxFrequency > k, shrink it until valid again;
        // use map to keep tracking of the characters and frenquencies;
        // use int res to update our result;
        int res = 0;
        int left = 0;
        int maxF = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            // update maxF
            maxF = Math.max(maxF, map.get(c));
            while(right - left + 1 - maxF > k){
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++; 
            }
            res = Math.max(right - left + 1, res);
        }
        return res;    
    }
        
    
}