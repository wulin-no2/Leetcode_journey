class Solution {
    public int characterReplacement(String s, int k) {
        // sliding window
        // for the window, we check if it's a valid window(windowLength - maxFrequent) <= k
        // if valid, update res, windowLength - maxFrequent and go forward
        // if not valid, move left until it's valid
        int left = 0;
        int maxFrequency = 0;
        int res = 0;
        // we need to count the frequency of these letters
        int[] count = new int[26];
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            count[c - 'A']++; // update frequency
            maxFrequency = Math.max(maxFrequency, count[c - 'A']);
            while(right - left + 1 - maxFrequency > k){
                count[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;


        
    }
}