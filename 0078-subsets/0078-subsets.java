class Solution {
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        // backtracking
        backtracking(res, path, nums, 0);
        return res;
    }
    public void backtracking(List<List<Integer>> res, List<Integer> path, int[] nums, int startIndex){
        // collect results
        res.add(new ArrayList(path));
        // one node
        for(int i = startIndex; i < nums.length; i++){
            // add elements to list
            path.add(nums[i]);
            // backtracking
            backtracking(res, path, nums, i + 1);
            // remove
            path.remove(path.size() -1);
        }
    }
}