class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // for each str, we encode it;
        // if the code exist, then we put str in the same area;
        // map<code, list>
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            // encode str
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String code = new String(chars); // convert char array to string
            // check if map contains the code
            // if not contains, put code and str in the map and create a new list
            if(!map.containsKey(code)){
                map.put(code, new ArrayList<>());
            }
            // if contains, put str in the list
            map.get(code).add(str);
        }
        // now we got the map
        // we convert it into our list result;
        // go through the values and put them into list one by one
        return new ArrayList<>(map.values());
    }
}