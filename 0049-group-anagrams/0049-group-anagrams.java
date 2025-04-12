class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // encode each string into a key, make the strings with same code into a list as a value
        // now there is a map for us to track all the strings with same code
        Map<String, List<String>> map = new HashMap<>();
        // finally turn map into list

        // first question is, how to encode string?
        // encode string into int array, then turn int array into string; 
        for(String str: strs){
            // encode str
            int[] arr = new int[26];
            // turn str into int array
            for(int i = 0; i < str.length(); i++){
                arr[str.charAt(i) -'a']++;
            }
            // turn int array into string
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++){
                if(arr[i] != 0) sb.append(arr[i]).append((char)(i + 'a'));
            }
            String code = sb.toString();
            // put code and str into map:
            map.computeIfAbsent(code, k->new ArrayList<>()).add(str);

        }
        // turn map into list;
        return new ArrayList<>(map.values());


        
    }
}