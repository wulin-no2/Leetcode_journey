class Solution {
    public int characterReplacement(String s, int k) {
        // slidingwindow
        // use int res to update result
        // use map to record chars and counts in the window
        // every time, check length of window - maxCount of char and see if it's less than k
        // if less than k, valid, update res;
        // if not, shrink window by move left until valid;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxf = 0; // track maxCount of the window
        for(int right = 0; right < s.length() ; right++){
            // get maxCount of char
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            // get maxf of the window
            maxf = Math.max(map.get(c), maxf);
            // compare with k to check if window is valid
            // if invalid
            while(right - left + 1 - maxf > k){
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1); 
        }
        return res;
    }
}