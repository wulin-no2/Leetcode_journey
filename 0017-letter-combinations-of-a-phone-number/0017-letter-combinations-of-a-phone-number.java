class Solution {
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String path = "";
        String[] s = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backtracking(digits, s, 0, res, path);
        return res;
    }
    void backtracking(String digits, String[] s, int index, List<String> res, String path){
        // end condition:
        if(digits.length() == 0) return;
        if(path.length() == digits.length()){
            // get result;
            res.add(path);
            return;
        }
        // each level:
        int num = digits.charAt(index) - '0';
        for(int j = 0 ; j < s[num - 2].length(); j++){
            path = path + s[num - 2].charAt(j);
            backtracking(digits, s, index + 1, res, path);
            path = path.substring(0, path.length() - 1);
        }  
    }
}