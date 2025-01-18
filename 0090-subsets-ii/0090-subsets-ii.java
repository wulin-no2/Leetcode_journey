class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // backtracking
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        // sort it to avoid dupication
        Arrays.sort(nums);
        backtracking(nums, res, path, 0);
        return res;
        
    }
    public void backtracking(int[] nums, List<List<Integer>> res, List<Integer> path, int startIndex){
        //base case
        res.add(new ArrayList<>(path));
        for(int i = startIndex ; i < nums.length; i++){
            // avoid duplication in same layer
            if(i > startIndex && nums[i]==nums[i-1]) continue;
            path.add(nums[i]);
            backtracking(nums, res, path, i + 1);
            path.remove(path.size() - 1);
        }


    }
}