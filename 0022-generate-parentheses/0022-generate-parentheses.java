class Solution {
    public List<String> generateParenthesis(int n) {
        // record count of used left ul and used right ur, 
        // if ul > ul, then we could choose both l and r in this round, 
        // otherwise we could only choose l
        // if ur == n, end it
        List<String> res = new ArrayList<>();
        backtracking(res, new StringBuilder(), 0, 0, n);
        return res;
        
    }
    public void backtracking(List<String> res, StringBuilder path, int ul, int ur, int n){
        // get result
        if (path.length() == 2 * n) {
            res.add(path.toString());
            return;
        }
        // Can we add a '(' ?
        if (ul < n) {
            path.append('(');
            backtracking(res, path, ul + 1, ur, n);
            path.deleteCharAt(path.length() - 1);
        }

        if(ul > ur) {
            path.append(')');
            backtracking(res, path, ul, ur + 1, n);
            path.deleteCharAt(path.length() - 1);
        }
    }
}