class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // backtracking
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int[] used = new int[nums.length]; // used to track if we use this element or not 
        backtracking(nums, res, path, used);
        return res;
    }
    public void backtracking(int[] nums, List<List<Integer>> res, List<Integer> path, int[] used){
        // base case
        if(path.size()==nums.length) res.add(new ArrayList<>(path));
        for(int i = 0 ; i < nums.length ; i++){
            if(used[i] == 0) {
                path.add(nums[i]); 
                used[i] = 1;
                backtracking(nums, res, path, used);
                path.remove(path.size() - 1);
                used[i] = 0;
            }
        }


    }
}