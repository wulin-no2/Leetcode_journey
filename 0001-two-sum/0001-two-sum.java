class Solution {
    public int[] twoSum(int[] nums, int target) {
        // record the number and the index, using map
        HashMap<Integer, Integer> map = new HashMap<>();
        // traverse
        for(int i = 0; i < nums.length; i++){
            int aim = target - nums[i];
            if(map.containsKey(aim)) return new int[]{map.get(aim), i};
            map.put(nums[i],i);
        }
        return null;
        
    }
}