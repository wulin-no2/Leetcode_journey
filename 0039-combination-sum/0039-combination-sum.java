class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // backtracking
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(candidates, target, res, path, 0);
        return res;
        
    }
    public void backtracking(int[] candidates, int target, List<List<Integer>> res, List<Integer> path, int startIndex){
        // base base
        if(target == 0) {res.add(new ArrayList<>(path)); return;}
        if(target < 0) return;
        for(int i = startIndex; i < candidates.length ; i++){
            path.add(candidates[i]);
            backtracking(candidates, target-candidates[i], res, path, i);
            path.remove(path.size() - 1);
        } 


    }
}