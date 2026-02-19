class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        // store the value and the counts, using map
        // pop in s to map
        // pop out from map
        // use map or array of length 26
        // method 1, map
        Map<Character, Integer> map = new HashMap<>();
        for(char i: s.toCharArray()){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(char i: t.toCharArray()){
            if(! map.containsKey(i) || map.get(i) == 0) return false;
            // if map.get(i) > 0, then map.put(i, map.get(i) - 1);
            map.put(i, map.get(i) - 1);
        }
        return true;
        
    }
}