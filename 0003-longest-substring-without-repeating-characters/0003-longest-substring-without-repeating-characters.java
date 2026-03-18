class Solution {
    public int lengthOfLongestSubstring(String s) {
        // sliding window
        // if not duplicate, right++; if duplicate, left++ until not duplidate
        // keep updating length;
        int length = s.length();
        if(length == 0 || length == 1) return length;
        int left = 0;
        int right = 1;
        int res = 1;
        // use set to detect duplicates
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(left));
        while(right < length){
            char temp = s.charAt(right);
            while(set.contains(temp)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(temp);
            res = Math.max(set.size(), res);
            right++;
        }
        return res;
    }
}