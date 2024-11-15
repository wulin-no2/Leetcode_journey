class Solution {
    public int lengthOfLongestSubstring(String s) {
        // slidingwindow
        // use set to store existing element in window
        // use currLength to record temporary max value
        // use res to record final result;
        int left = 0;
        Set<Character> set = new HashSet<>();
        int res = 0;
        int currLength = 0;
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            if(! set.contains(c)){
                currLength = right - left + 1;
                res = Math.max(res, currLength);
            }
            else{
                while(set.contains(c)){
                    set.remove(s.charAt(left));
                    left++;
                    currLength = right - left + 1;
                }
            }
            set.add(c);
        }
        return res;
    }
}