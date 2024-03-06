class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1, 9);
        return res;
        
    }
    void backtracking(int k, int target, int start, int end){
        // end condition:
        if(path.size() == k && target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        // each level:
        for(int i = start ; i <= end ; i++){
            path.add(i);
            backtracking(k, target - i, i + 1, end);
            path.remove(path.size() - 1);
        }
    }
}