class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        // use a sliding window to checkValid
        int left = 0;
        for(int right = left + s1.length() - 1; right < s2.length() ; right++){
            String sub = s2.substring(left, right + 1);
            if(isValid(s1, sub)) return true;
            left++;
        }
        return false;
    }
    boolean isValid(String s1, String s2){
        // check if s2 is s1's permutation when they're the same length
        int[] arr = new int[26];
        for(char c: s1.toCharArray()){
            arr[c-'a']++;
        }
        for(char c: s2.toCharArray()){
            arr[c-'a']--;
            if(arr[c-'a'] < 0) return false;
        }
        return true;
    }
}