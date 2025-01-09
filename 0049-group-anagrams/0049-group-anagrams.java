class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // encode all the strs, then group them based on their code
        // use map
        Map<String, List<String>> map = new HashMap<>(); // code, list of strings with same code
        for(String str: strs){
            // get code
            // array hashing, then turn it into String code
            int[] arr = new int[26];
            for(char c: str.toCharArray()){
                arr[c-'a']++;
            }
            StringBuilder sb =  new StringBuilder();
            // turn arr into sorted str
            for(int i = 0 ; i < arr.length; i++){
                if(arr[i] != 0) sb.append(i + 'a').append(arr[i]);
            }
            // turn sb into str
            String code = sb.toString();

            // add str into map's list;
            map.computeIfAbsent(code, k -> new ArrayList<>()).add(str);
        }
        // turn map's values into list
        return new ArrayList<>(map.values()); 
    }
}