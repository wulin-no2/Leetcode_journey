class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
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
        // check if all counts are zero
//         for(int count : map.values()) {
//             if(count != 0) return false;
//         }
        
        return true;
        
    }
}