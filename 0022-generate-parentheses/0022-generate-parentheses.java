class Solution {
    public List<String> generateParenthesis(int n) {
        // backtracking 
        // left >= right
        // left <= n
        List<String> res = new ArrayList<>();
        backtracking(n, "", 0, 0, res);
        return res;
        
        
    }
    public void backtracking(int n, String curr, int left, int right, List<String> res){
        // base case
        if(left==n && right==n) {res.add(curr); return;}
        // recursive 
        if(left < n) backtracking(n, curr+"(",left+1, right, res);
        if(right < left) backtracking(n, curr+")",left, right+1,res);
    }
}