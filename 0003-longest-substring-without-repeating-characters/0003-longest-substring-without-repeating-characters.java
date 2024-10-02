class Solution {
    public int lengthOfLongestSubstring(String s) {
        // array hashing, record last seen index for each character
        int[] arr = new int[128];
        int res = 0;
        // use sliding window to track unique substring
        int left = 0;
        // traverse s
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            // if s.charAt(i) in arr, update its index, move left, update res
            if(arr[c] > 0 && arr[c] >= left) left = arr[c];
            res = Math.max(res,i - left + 1);
            arr[c] = i + 1; 
        }
        // return max(res, count)
        return res;
    }
}