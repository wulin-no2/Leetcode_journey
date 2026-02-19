class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // we have to encode the type of each string.
        // for each string, we have to remember it's letters and each count of them
        // we use letter + number to encode them
        // then use map to put them together, each code is a key
        Map<String, List<String>> map = new HashMap<>();
        // for(String str: strs){
        //     // 1. encode it into string
        //     // 1.1. get array code
        //     int[] arr = new int[26];
        //     for(char i : str.toCharArray()){
        //         arr[i - 'a']++;
        //     }
        //     // 1.2. get string code
        //     StringBuilder sb = new StringBuilder();
        //     for(int i = 0; i < 26; i++){
        //         sb.append(i + 'a').append(arr[i]);
        //     }
        //     String s = sb.toString();
        //     // 2. put it into map
        //     map.computeIfAbsent(s, key -> new ArrayList<String>()).add(str);
        // }
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            
            map.get(sortedWord).add(word);
        }
        // put values into a list
        // List<List<String>> res = new ArrayList<>();
        // for(List<String> value: map.values()){
        //     res.add(value);
        // }
        // return res;
        return new ArrayList<>(map.values());
    }
}