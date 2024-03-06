class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return res;
    }
    private void backtracking(int n, int k, int start){
        // end conditon:
        if(path.size() == k){
            // get result:
            res.add(new ArrayList<>(path));
            return;
        }
        // each level logic:
        for(int i = start; i <= n ; i++){
            if( n - i + 1 < (k - path.size())) return; // trim;
            path.add(i);
            backtracking(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}