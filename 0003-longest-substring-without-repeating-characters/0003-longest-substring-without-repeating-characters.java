class Solution {
    public int lengthOfLongestSubstring(String s) {
        // slidingwindow
        // use set to store existing element in window
        // use currLength to record temporary max value
        // use res to record final result;
        int left = 0;
        Set<Character> set = new HashSet<>();
        int res = 0;
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}