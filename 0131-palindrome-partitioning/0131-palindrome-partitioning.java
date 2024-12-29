class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path =  new ArrayList<>();
        backtracking(res, path, s, 0);
        return res;
        
    }
    public void backtracking(List<List<String>> res,List<String> path, String s, int startIndex){
        if(startIndex == s.length()){
            res.add(new ArrayList(path));
            return;
        }
        for(int i = startIndex ; i < s.length() ; i++){
            if(isPalindrome(s, startIndex, i)){
                path.add(s.substring(startIndex, i + 1));
                backtracking(res, path, s, i + 1);
                path.remove(path.size()-1);
            }


        }
    }
    // Helper function to check if a substring is a palindrome
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
