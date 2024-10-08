class Solution {
    public int lengthOfLongestSubstring(String s) {
        // sliding window
        // left and right pointers
        int res = 0;
        // without repeating characters: use set to store elements
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            // if(! set.contains(c)) {
            //     set.add(c);
            // }
            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}