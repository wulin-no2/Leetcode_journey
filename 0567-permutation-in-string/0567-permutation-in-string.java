class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // all the frequencies of 26 letters should be the same
        // 2 array hashings,compare substring's hashing and s1's hashing
        // how to compare?
        // count how many letters have same frequencies
        if(s1.length() > s2.length()) return false;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26]; 
        for(int i = 0; i < s1.length() ; i++){ // encode s1 and s2.first substring
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }
        // count count how many letters have same frequencies
        int count = 0;
        for(int i = 0; i < 26; i++){
            if(arr1[i]==arr2[i]) count++;
        }
        // move sliding window. if count == 26, return true;
        for(int i = s1.length() ; i < s2.length(); i++){
            if(count==26) return true;
            int leave = s2.charAt(i - s1.length()) - 'a';
            int in = s2.charAt(i) - 'a';
            if(arr1[leave]==arr2[leave]) count--;
            if(arr2[leave]-arr1[leave]==1) count++;
            // update arr2
            arr2[leave]--;
            if(arr1[in]==arr2[in]) count--;
            if(arr1[in]-arr2[in]==1) count++;
            arr2[in]++;


        }
        return count==26;
        
    }
}