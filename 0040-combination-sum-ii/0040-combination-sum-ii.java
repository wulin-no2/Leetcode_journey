class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // sort the list so we won't have duplicate combinations
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(candidates, 0, target, path, res);
        return res;
    }
    public void backtracking(int[] candidates, int startIndex, int target, List<Integer> path, List<List<Integer>> res){
        if(target < 0 || path.size() > candidates.length) return;
        if(target == 0) res.add(new ArrayList<>(path));
        for(int i = startIndex; i < candidates.length ; i++){
            if(i > startIndex && candidates[i] == candidates[i - 1]) continue; // jump the duplicate combinations
            path.add(candidates[i]);
            backtracking(candidates, i + 1, target - candidates[i], path, res);
            path.remove(path.size() - 1);
        }

    }
}