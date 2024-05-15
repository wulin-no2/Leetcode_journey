class Solution {
    public int[] twoSum(int[] nums, int target) {
        // // put num into map. then find target - num; and return their index;
        // Map<Integer, Integer> map = new HashMap<>();
        // for(int i = 0 ; i < nums.length ; i++){
        //     int temp = target - nums[i];
        //     if(map.containsKey(temp)) return new int[]{map.get(temp), i};
        //     map.put(nums[i], i);
        // }
        // return new int[2];
        
        // find 1 elements by index(array, map)
        // solution 1: brute force
        for(int i = 0; i < nums.length - 1; i++){
            int temp = target - nums[i];
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j]==temp) return new int[]{i,j};
            }
        }
        return null;
    }
}      
        
        
