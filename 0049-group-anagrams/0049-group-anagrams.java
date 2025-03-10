class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // encode each string in a rule
        // how to encode them? char+number+char+number in letter's order
        // use map to store the result: map<String, List<String>>, then turn it into res;
        // how to encode a string? using array hashing
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            int[] arr = new int[26];
            for(char c: str.toCharArray()){
                arr[c-'a']++;
            }
            // turn arr to string:
            StringBuilder code = new StringBuilder();
            for(int i = 0; i < arr.length; i++){
                code.append((char)(i + 'a')+ arr[i]);
            }
            // add it to map
            map.computeIfAbsent(code.toString(), k->new ArrayList<>()).add(str);
        }

        // turn map into res
        List<List<String>> res = new ArrayList<>(map.values());
        return res;
        
        
    }
}