class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList(), nums, 0);
        return list;
        
        
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start){
        if(tempList.size() == nums.length) list.add(new ArrayList(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, 0);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}