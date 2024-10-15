class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // use map for tracking
        HashMap<String, List<String>> map = new HashMap<>();
        // traverse strs
        // sort and use sortedString as code
        for(String str: strs){
            // get str and sort it as code
            char[] arr = str.toCharArray(); 
            Arrays.sort(arr);
            // String sortedStr = arr.toString();
            String sortedStr = new String(arr);  // Correctly convert sorted char array to String
            
            // check if code in map or not;
            map.computeIfAbsent(sortedStr, k->new ArrayList()).add(str);

        }
        
        
        
        
        
        
        /* use code
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
        */
        return new ArrayList<>(map.values());
    }
}