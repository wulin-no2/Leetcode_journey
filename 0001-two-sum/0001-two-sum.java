class Solution {
    public int[] twoSum(int[] nums, int target) {
        // use map to remember index and value of each element
        Map<Integer, Integer> map = new HashMap<>(); // value, index
        for(int i = 0 ; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)) return new int[]{map.get(complement), i};
            map.put(nums[i], i);
        }
        return new int[]{};
        
    }
}