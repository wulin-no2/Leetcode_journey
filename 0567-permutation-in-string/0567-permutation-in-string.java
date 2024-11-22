class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false; // Edge case: s1 longer than s2

        // hashing
        // use 2 arrays to record the letters and frequencies in s1 and window;
        // comapre them, then move window forward
        // the problem is: how to compare? 1. directly compare the arrays; 2. use a number to track the count of letters of them that have same frequencies
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        int matches = 0;
        for(int i = 0; i < s1.length(); i++){
            arr1[s1.charAt(i) -'a'] ++;
            arr2[s2.charAt(i) -'a'] ++;
        }
        // calculate matches
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i]==arr2[i]) matches++;
        }
        
        // move window forward
        for(int i = s1.length() ; i < s2.length(); i++){
            if(matches==26) return true;
            //int outIdx = s2.charAt(i - s1.length()) - 'a'; // Character leaving the window
            //int inIdx = s2.charAt(i) - 'a'; // Character entering the window


            
            
            
            char c1 = s2.charAt(i - s1.length());
            char c2 = s2.charAt(i);
            if(arr1[c1-'a'] == arr2[c1-'a']) matches--;
            else if(arr1[c1-'a'] == arr2[c1-'a']-1) matches++;
            arr2[c1-'a']--;
            if(arr1[c2-'a'] == arr2[c2-'a'] + 1) matches++;
            else if(arr1[c2-'a'] == arr2[c2-'a']) matches--;
            arr2[c2-'a']++;
        }
        return matches == 26;
        
        
    }
}