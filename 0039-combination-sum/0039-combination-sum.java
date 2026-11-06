class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // backtracking
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(candidates, 0, target, path, res);
        return res;
    }
    public void backtracking(int[] candidates, int startIndex, int target, List<Integer> path, List<List<Integer>> res){
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList(path));
            return;
        }
        for(int i = startIndex; i < candidates.length; i++){
            path.add(candidates[i]);
            backtracking(candidates, i, target - candidates[i], path, res);
            path.remove(path.size() - 1);
        }
    }
}