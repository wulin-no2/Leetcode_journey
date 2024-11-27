class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(candidates, target, 0, res, list);
        return res;
        
    }
    public void backtracking(int[] candidates, int target, int index, List<List<Integer>> res, List<Integer> list){
        // base case, get result
        if(target==0) {
            res.add(new ArrayList(list)); 
            return;
        }
        for(int i = index; i < candidates.length ; i++){
            // skip if current candidate exceeds the remaining target
            if(candidates[i] > target) continue;
            
            // include current candidate in the combination
            list.add(candidates[i]);
            
            // recursively try to find combinations with the updated target
            backtracking(candidates, target - candidates[i], i, res, list);
            
            // backtrack: remove last element to explore others
            list.remove(list.size() - 1);
        }
    }
}