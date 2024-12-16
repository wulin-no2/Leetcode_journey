class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        // backtracking
        // use list path to get each subset
        // use list res to collect all the results
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(res, path, nums, 0);
        return res;
    }
    public void backtracking(List<List<Integer>> res, List<Integer> path, int[] nums, int startIndex){
        // collect result:
        res.add(new ArrayList(path));
        // for loop to get all the result:
        for(int i = startIndex; i < nums.length; i++){
            path.add(nums[i]);
            backtracking(res, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}