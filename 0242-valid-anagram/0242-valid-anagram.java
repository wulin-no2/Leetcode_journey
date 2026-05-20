class Solution {
    public boolean isAnagram(String s, String t) {
        // We use int array with length = 26 to count the letters in two strings
        // first we check the length
        if(s.length() != t.length()) return false;
        // then we create our array
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++){
            if(arr[i] != 0) return false;
        }
        return true;

        
    }
}