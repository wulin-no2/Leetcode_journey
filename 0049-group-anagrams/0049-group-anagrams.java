class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            // encode it
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String code = new String(chars);
            // put it in map
            if(!map.containsKey(code)){
                map.put(code, new ArrayList<>());
            }
            map.get(code).add(str);
        }
        return new ArrayList<>(map.values());
        
    }
}