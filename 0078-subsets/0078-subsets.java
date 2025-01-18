class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // backtracking
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(nums, 0, res, path);
        return res;
    }
    public void backtracking(int[] nums, int startIndex, List<List<Integer>> res, List<Integer> path){
        // end 
        res.add(new ArrayList<>(path));
        for(int i = startIndex ; i < nums.length ; i++){
            path.add(nums[i]);
            backtracking(nums, i + 1, res, path);
            path.remove(path.size() - 1);
        }

    }
}