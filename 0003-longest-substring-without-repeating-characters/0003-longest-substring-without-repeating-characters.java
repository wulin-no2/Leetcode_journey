class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;
        // sliding window
        // use map or set to track characters in the window
        Map<Character, Integer> map = new HashMap<>();
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
        // for the right side character:
        // 1. check if it's in map or set, move left, update map or set, put it in, update maxLength
            if(map.containsKey(c)){
                left = Math.max(map.get(c) + 1, left);
            }
        // if it's not, put it in, update maxLength
            map.put(c, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}