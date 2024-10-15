class Solution {
    public boolean isAnagram(String s, String t) {
        
        
        if(s.length()!=t.length()) return false;
        /*
        // use map to track elements and counts;
        HashMap<Character, Integer> map = new HashMap<>();
        // traverse 1st string;
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // traverse 2nd string;
        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) - 1);
            if(map.get(c) < 0) return false;
        }
        return true;
        */
        
        // use array as hashing cause we only have 26 letters
        int[] arr = new int[26];
        for(char c: s.toCharArray()){
            arr[c-'a'] += 1;
        }
        for(char c: t.toCharArray()){
            arr[c-'a'] -= 1;
            if(arr[c-'a'] < 0) return false;
            
        }
        return true;
        
        
        
        
    }
}