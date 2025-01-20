class Solution {
    public List<String> letterCombinations(String digits) {
        // mapping digits to string
        // backtracking
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");        
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        if(digits==null || digits.length()==0) return res;
        backtracking(digits, res, path, 0, map);
        return res;
    }
    public void backtracking(String digits, List<String> res, StringBuilder path, int index, Map<Character, String> map){
        // base case
        if(index == digits.length()) {res.add(path.toString()); return;}
        Character c = digits.charAt(index);
        String candidates = map.get(c);
        for(int i = 0; i < candidates.length() ; i++){
            char candidate = candidates.charAt(i);
            path.append(candidate);
            backtracking(digits, res, path, index + 1, map);
            path.deleteCharAt(path.length() - 1);
        }
    }
}