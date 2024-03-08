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
    

    // do backtracking again;
    /*
    public List<String> letterCombinations(String digits) {
        // first base case:
        if(digits.length() == 0) return new ArrayList();
        // make a string[] array to store different letters in each digit;
        String[] book = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        // use a list to store the result;
        List<String> res = new ArrayList<>();
        // backtracking;
        backtrack("", digits, book, res);
        return res; 
    }
    // how to write backtrack;
    private void backtrack(String tempStr, String next, String[] book, List<String> res){
        // everytime, if it's the end of the backtrack, we add the temp to result list;
        if(next.length() == 0) res.add(tempStr);
        else{ // or we still need to backtrack;
            String letters = book[next.charAt(0) - '2']; // see we can get which letter from next digit;
            for(char letter: letters.toCharArray()){
                backtrack(tempStr + letter, next.substring(1), book, res);
            }
        }
    }
    */

    // another approach:
    /*
    method combine is to add new letters to old list, using 2 for-loop.
    for example:
    gave digits = "23"
    i=0 -> result=combine("abc", [""]) ---> [a,b,c];
    i=1 -> result=combine("def", [a,b,c]) ---> [ad,bd,cd, ae,be,ce, af,bf,cf];
    */
    /*
    public static List<String> letterCombinations(String digits) {
        String digitletter[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<String>();

        if (digits.length()==0) return result;

        result.add("");
        for (int i=0; i<digits.length(); i++) 
            result = combine(digitletter[digits.charAt(i)-'0'],result);

        return result;
    }

    public static List<String> combine(String digit, List<String> l) {
        List<String> result = new ArrayList<String>();

        for (int i=0; i<digit.length(); i++) 
            for (String x : l) 
                result.add(x+digit.charAt(i));

        return result;
    }
    */
}