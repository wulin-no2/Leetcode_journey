class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(nums, 0, res, list);
        return res;
        
    }
    public void backtracking(int[] nums, int index, List<List<Integer>> res, List<Integer> list){
        // base case, get result
        if(index == nums.length){
            res.add(new ArrayList<>(list)); // add a copy of the current list
            return;
        }
        // one layer - choose the current element
        list.add(nums[index]);
        backtracking(nums, index + 1, res, list);
        list.remove(list.size()-1);
        
        // one layer - don't choose it
        backtracking(nums, index + 1, res, list);
    }
    
}