class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 1) we have to record what numbers there are in the array. 2) we have to record the indices
        // use HashMap so there are 2 dimension for us to use.
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<= nums.length -1;i++){
            // if we find target-nums[i] in the map, the index is our result;
            if(map.containsKey(target-nums[i])) return new int[]{i, map.get(target-nums[i])};
            // else, add elements in the array into map;
            map.put(nums[i], i);
        }
        return new int[] {};
        
        
    }
}