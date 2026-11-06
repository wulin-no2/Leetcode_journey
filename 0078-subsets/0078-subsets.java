class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // backtracking
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(nums, 0, path, res);
        return res;
    }
    public void backtracking(int[] nums, int startIndex, List<Integer> path, List<List<Integer>> res){
        res.add(new ArrayList(path));
        if(startIndex > nums.length - 1) return;
        for(int i = startIndex; i < nums.length ; i++){
            path.add(nums[i]);
            backtracking(nums, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}