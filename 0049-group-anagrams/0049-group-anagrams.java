class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // use map for tracking
        HashMap<String, List<String>> map = new HashMap<>();
        // traverse strs
        for(String str: strs){
            // convert it into a code and group by code
            int[] codeArr = new int[26];
            for(char c : str.toCharArray()){
                codeArr[c-'a']++;
            }
            
            // convert arr to string
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i < 26;i++){
                sb.append(codeArr[i]).append('#');
            }
            String code = sb.toString();
            
            
            // if code in map, group them; if not, put into map;
            map.computeIfAbsent(code, k-> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}