class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) return false;
        // we have to record the characters and the counts, using map;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for(int i = 0; i < sc.length; i++){
            map.put(sc[i], map.getOrDefault(sc[i], 0) + 1);
        }
        for(int i = 0; i < tc.length; i++){
            if(! map.containsKey(tc[i])) return false;
            else map.put(tc[i],map.get(tc[i])-1);
        }
        // if(map.isEmpty()) return true;// no!! value maybe 0, but it doesn't mean map is empty;
        for(int count: map.values()){
            if(count!=0) return false;
        }
        return true;
            
        
    }
}