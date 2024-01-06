class Solution {
    public boolean isAnagram(String s, String t) {
        // analyze:
        // 1. if lengths is different, return false;
        // 2. put elements of s into a hashset, then see if t contains these elements;
        // if all contains, return true; else, return false;
        
        // Time and space complexity is O(n); 
        
        // the problem is, we have to count how many times each letter appears;
        // so we can't use hashset. We have to use hashmap.put(charAt(i),count);
        // solution1: put them into 2 hashmap, and see if they contains same elements;
        // solution2: put s into 1 hashmap, and compare with t;
        
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        // put elements of s into hashmap;
        for(int i = 0; i < s.length(); i++){
            int currentCount1 = map1.getOrDefault(s.charAt(i),0) + 1;
            int currentCount2 = map2.getOrDefault(t.charAt(i),0) + 1;
            map1.put(s.charAt(i), currentCount1);
            map2.put(t.charAt(i), currentCount2);
        }
        // see if they're equal;
        return map1.equals(map2);
    }
}