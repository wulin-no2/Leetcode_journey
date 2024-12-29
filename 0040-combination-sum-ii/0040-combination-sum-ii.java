class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // each number can only be used once; startIndex
        // no duplicate combinations;
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(res, path, candidates, target, 0);
        return res;
    }
    public void backtracking(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int startIndex){
        if(target==0){
            res.add(new ArrayList(path));
            return;
        }
        if(target < 0) return;
        for(int i = startIndex ; i < candidates.length; i++){
            if(i > startIndex && candidates[i]==candidates[i-1]) continue;
            path.add(candidates[i]);
            backtracking(res, path, candidates, target-candidates[i], i + 1);
            path.remove(path.size() - 1);
        }
    }

}