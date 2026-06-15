class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // cause they only consist of letters, we can compare them with Arrays.equals(), O(1)
        if(s1.length() > s2.length()) return false;
        // we encode them into char array
        int[] code = new int[26];
        int[] windowCode = new int[26];
        for(char c: s1.toCharArray()){
            code[c - 'a']++;
        }
        for(char c: s2.substring(0, s1.length()).toCharArray()){
            windowCode[c - 'a']++;
        }
        if(Arrays.equals(code, windowCode)) return true;
        // move window
        int left = 1;
        for(int right = s1.length(); right < s2.length() ; right++){
            // get windowCode
            windowCode[s2.charAt(right) - 'a']++;
            windowCode[s2.charAt(left - 1) - 'a']--;
            // compare with code
            if(Arrays.equals(code, windowCode)) return true;
            left++;
        }
        return false;

        
    }
}