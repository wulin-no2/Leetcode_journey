class Solution {
    public int lengthOfLongestSubstring(String s) {
        // use HashMap and 2 pointers
        // Sliding window
        // no repeat, so need to record the frequency. We use hashmap<element,count>.
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        // 2 pointers to record window's left and right;
        int i = 0; // left
        int j = 0; // right
        while(j < s.length()){
            // put element into map and compare window's width with map.size();
            // window's width = j - i + 1
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if(map.size() == j - i + 1){
                // means there are not duplicated elements;
                // update max. either max or window's width;
                max = Math.max(max, j - i + 1);
                j++;
            }
            else if(map.size() < j - i + 1){
                // means there exist duplicated elements;
                // move left and remove the ith element from map until they're the same;
                // put first, then move i;
                while(map.size() < j - i + 1){

                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if(map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
                    i++;
                }
                j++; 
            }
        }
        return max;
        
        
        
        
        
        
        
        
        
        
        
        
        /*
        
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while(j < s.length()){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if(map.size() == j - i + 1){
                max = Math.max(max, j - i + 1);
                j++;
            }else if(map.size() < j - i + 1){
                while(map.size() < j - i + 1){
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if(map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
                    i++;
                }
            j++;
            }
        }
        return max;
        */
    }
}