class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        // same elements with same counts
        // HashMap
        Map<Character, Integer> map = new HashMap<>(); // element, count
        // Travers s and put elements into map;
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        // Travers t and get elements out of map;
        for(int i = 0; i < t.length(); i++){
            if(! map.containsKey(t.charAt(i))) return false;
            map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            if(map.get(t.charAt(i)) < 0) return false;
        }
        return true;
    }
    
}