class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // backtracking
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        // the elements are not unique, avoid duplication
        Arrays.sort(candidates);
        backtracking(candidates, target, res, path, 0);
        return res;

    }
    public void backtracking(int[] candidates, int target, List<List<Integer>> res, List<Integer> path, int startIndex){
        // base case
        if(target == 0) res.add(new ArrayList<>(path));
        if(target < 0) return;
        for(int i = startIndex ; i < candidates.length ; i++){
            if(i > startIndex && candidates[i]==candidates[i-1]) continue;
            path.add(candidates[i]);
            backtracking(candidates, target - candidates[i], res, path, i + 1);
            path.remove(path.size() - 1);
        }

    }
}