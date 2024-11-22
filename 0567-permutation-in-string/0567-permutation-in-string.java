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
            int outIdx = s2.charAt(i - s1.length()) - 'a'; // Character leaving the window
            int inIdx = s2.charAt(i) - 'a'; // Character entering the window
            if(arr1[outIdx] == arr2[outIdx]) matches--;
            else if(arr1[outIdx] == arr2[outIdx]-1) matches++;
            arr2[outIdx]--;
            if(arr1[inIdx] == arr2[inIdx] + 1) matches++;
            else if(arr1[inIdx] == arr2[inIdx]) matches--;
            arr2[inIdx]++;
        }
        return matches == 26;
        
        
    }
}