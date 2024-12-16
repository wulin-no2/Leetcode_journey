class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // backtracking 
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(res, path, candidates, target, 0);
        return res;
    }
    public void backtracking(List<List<Integer>> res, List<Integer> path,int[] candidates, int target, int startIndex){
        // collect result;
        if(target==0) {
            res.add(new ArrayList(path));
            return;
        }
        // for loop to traverse a node:
        for(int i = startIndex; i < candidates.length; i++){
            if (target < candidates[i]) {
                continue;
            }
            path.add(candidates[i]);
            target -= candidates[i];
            backtracking(res, path, candidates, target, i);
            path.remove(path.size()-1);
            target += candidates[i];
        }
    }
}