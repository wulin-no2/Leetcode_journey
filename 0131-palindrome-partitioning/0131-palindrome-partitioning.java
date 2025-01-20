class Solution {
    public List<List<String>> partition(String s) {
        // brute force
        // 2 pointers 
        // second pointer is for traversing the string and partitioning the string
        // first pointer is to explore if there's a valid palindrome
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        // if(s.length()== 1) {path.add(s.charAt(0)); res.add(path); return res;}
        backtracking(s, res, path, 0);
        return res;
    }
    public void backtracking(String s, List<List<String>> res, List<String> path, int startIndex){
        // base case
        if(startIndex == s.length()) {res.add(new ArrayList<>(path)); return;}
        for(int i = startIndex ; i < s.length() ; i++){
            // check if substring is valid
            if(isValid(s, startIndex, i)) {
                path.add(s.substring(startIndex, i + 1));
                backtracking(s, res, path, i + 1);
                path.remove(path.size()-1);
            }
        }
    }
    public boolean isValid(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;

    }
}