class Solution {
    public int[] twoSum(int[] nums, int target) {
        // hashing, map
        // put value, index into map
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length ; i++){
            int val = nums[i];
            if(! map.containsKey(target - val)) map.put(val, i);
            else return new int[]{i, map.get(target-val)};
        }
        return null;
    }
}