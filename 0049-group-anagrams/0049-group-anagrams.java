class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            // encode
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String code = new String(chars);
            // if the code is not in the map keySet, put the code in the map keySet, create an arrayList and add str to the arrayList;
            if(!map.containsKey(code)){
                map.put(code, new ArrayList<String>());
            }
            // if the code is in the map keySet, put str in the arrayList;
            map.get(code).add(str);
        }
        // res list from map.values
        return new ArrayList<>(map.values());
    }
}