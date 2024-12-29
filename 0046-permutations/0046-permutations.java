class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // backtracking
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length]; // Tracks whether nums[i] is used
        backtracking(res, path, nums, used);
        return res;

    }
    public void backtracking(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] used){
        if(path.size()==nums.length){
            res.add(new ArrayList(path));
            return;
        }
        for(int i = 0; i < nums.length ; i++){
            if(! used[i]) {
            path.add(nums[i]);
            used[i] = true;
            backtracking(res, path, nums, used);
            path.remove(path.size()-1);
            used[i] = false;
            }
        }
    }
}